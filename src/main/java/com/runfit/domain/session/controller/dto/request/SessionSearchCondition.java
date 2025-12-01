package com.runfit.domain.session.controller.dto.request;

import com.runfit.domain.session.entity.SessionLevel;
import com.runfit.domain.session.entity.SessionStatus;
import java.time.LocalDate;

public record SessionSearchCondition(
    String city,
    Long crewId,
    SessionLevel level,
    LocalDate date,
    SessionStatus status,
    String sort
) {
    public static SessionSearchCondition of(String city, Long crewId, SessionLevel level,
        LocalDate date, SessionStatus status, String sort) {
        return new SessionSearchCondition(city, crewId, level, date, status, sort);
    }
}
