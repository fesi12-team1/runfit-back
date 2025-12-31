package com.runfit.domain.session.repository;

import static com.runfit.domain.crew.entity.QCrew.crew;
import static com.runfit.domain.review.entity.QReview.review;
import static com.runfit.domain.session.entity.QSession.session;
import static com.runfit.domain.session.entity.QSessionLike.sessionLike;
import static com.runfit.domain.session.entity.QSessionParticipant.sessionParticipant;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.runfit.domain.session.controller.dto.response.CoordsResponse;
import com.runfit.domain.session.controller.dto.response.SessionListResponse;
import com.runfit.domain.session.controller.dto.response.SessionParticipantResponse;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SessionLikeRepositoryCustomImpl implements SessionLikeRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Slice<SessionListResponse> findLikedSessionsByUserId(Long userId, Pageable pageable) {
        List<SessionListResponse> content = queryFactory
            .select(Projections.constructor(SessionListResponse.class,
                session.id,
                session.crew.id,
                session.hostUser.userId,
                session.name,
                session.image,
                session.city,
                session.district,
                session.location,
                Projections.constructor(CoordsResponse.class,
                    session.latitude,
                    session.longitude
                ),
                session.sessionAt,
                session.registerBy,
                session.level,
                session.status,
                session.pace,
                session.maxParticipantCount,
                ExpressionUtils.as(
                    JPAExpressions.select(sessionParticipant.count())
                        .from(sessionParticipant)
                        .where(sessionParticipant.session.eq(session)),
                    "currentParticipantCount"
                ),
                Expressions.asBoolean(true),
                session.createdAt,
                ExpressionUtils.as(
                    Expressions.numberTemplate(Double.class,
                        "ROUND({0}, 1)",
                        JPAExpressions.select(review.ranks.avg())
                            .from(review)
                            .where(review.session.eq(session))
                    ),
                    "ranks"
                ),
                Expressions.constant(Collections.<SessionParticipantResponse>emptyList())
            ))
            .from(sessionLike)
            .join(sessionLike.session, session)
            .join(session.crew, crew)
            .where(
                sessionLike.user.userId.eq(userId),
                session.deleted.isNull()
            )
            .orderBy(sessionLike.likedAt.desc())
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize() + 1)
            .fetch();

        boolean hasNext = content.size() > pageable.getPageSize();
        if (hasNext) {
            content.remove(content.size() - 1);
        }

        return new SliceImpl<>(content, pageable, hasNext);
    }
}
