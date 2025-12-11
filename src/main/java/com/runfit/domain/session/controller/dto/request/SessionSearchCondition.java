package com.runfit.domain.session.controller.dto.request;

import com.runfit.domain.session.entity.SessionLevel;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record SessionSearchCondition(
    List<String> cities,
    List<String> districts,
    Long crewId,
    SessionLevel level,
    LocalDate dateFrom,
    LocalDate dateTo,
    LocalTime timeFrom,
    LocalTime timeTo,
    String sort
) {
    public static SessionSearchCondition of(
        List<String> cities,
        List<String> districts,
        Long crewId,
        SessionLevel level,
        LocalDate dateFrom,
        LocalDate dateTo,
        LocalTime timeFrom,
        LocalTime timeTo,
        String sort
    ) {
        return new SessionSearchCondition(
            cities, districts, crewId, level,
            dateFrom, dateTo, timeFrom, timeTo, sort
        );
    }
}
