package com.runfit.domain.session.controller.dto.response;

import com.runfit.domain.session.entity.SessionLevel;
import com.runfit.domain.session.entity.SessionStatus;
import java.time.LocalDateTime;
import java.util.List;

public record SessionListResponse(
    Long id,
    Long crewId,
    Long hostUserId,
    String name,
    String image,
    String city,
    String district,
    String location,
    CoordsResponse coords,
    LocalDateTime sessionAt,
    LocalDateTime registerBy,
    SessionLevel level,
    SessionStatus status,
    Integer pace,
    Integer maxParticipantCount,
    Long currentParticipantCount,
    Boolean liked,
    LocalDateTime createdAt,
    List<SessionParticipantResponse> participants
) {
    public SessionListResponse withParticipants(List<SessionParticipantResponse> participants) {
        return new SessionListResponse(
            id, crewId, hostUserId, name, image, city, district, location,
            coords, sessionAt, registerBy, level, status, pace,
            maxParticipantCount, currentParticipantCount, liked, createdAt, participants
        );
    }
}
