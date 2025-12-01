package com.runfit.domain.session.controller.dto.response;

import com.runfit.domain.session.entity.Session;
import com.runfit.domain.session.entity.SessionLevel;
import com.runfit.domain.session.entity.SessionStatus;
import java.time.LocalDateTime;

public record SessionResponse(
    Long id,
    Long crewId,
    Long hostUserId,
    String name,
    String description,
    String image,
    String location,
    LocalDateTime sessionAt,
    LocalDateTime registerBy,
    SessionLevel level,
    SessionStatus status,
    Integer pace,
    Integer maxParticipantCount,
    Long currentParticipantCount,
    LocalDateTime createdAt
) {
    public static SessionResponse from(Session session, long currentParticipantCount) {
        return new SessionResponse(
            session.getId(),
            session.getCrew().getId(),
            session.getHostUser().getUserId(),
            session.getName(),
            session.getDescription(),
            session.getImage(),
            session.getLocation(),
            session.getSessionAt(),
            session.getRegisterBy(),
            session.getLevel(),
            session.getStatus(),
            session.getPace(),
            session.getMaxParticipantCount(),
            currentParticipantCount,
            session.getCreatedAt()
        );
    }
}
