package com.runfit.domain.session.controller.dto.response;

public record CoordsResponse(
    Double lat,
    Double lng
) {
    public static CoordsResponse of(Double lat, Double lng) {
        if (lat == null && lng == null) {
            return null;
        }
        return new CoordsResponse(lat, lng);
    }
}
