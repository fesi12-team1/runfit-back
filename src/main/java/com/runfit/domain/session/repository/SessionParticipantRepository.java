package com.runfit.domain.session.repository;

import com.runfit.domain.session.entity.Session;
import com.runfit.domain.session.entity.SessionParticipant;
import com.runfit.domain.user.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SessionParticipantRepository extends JpaRepository<SessionParticipant, Long> {

    boolean existsBySessionAndUser(Session session, User user);

    Optional<SessionParticipant> findBySessionAndUser(Session session, User user);

    @Query("SELECT COUNT(sp) FROM SessionParticipant sp WHERE sp.session = :session")
    long countBySession(@Param("session") Session session);

    @Query("SELECT COUNT(sp) FROM SessionParticipant sp WHERE sp.session.id = :sessionId")
    long countBySessionId(@Param("sessionId") Long sessionId);
}
