package com.runfit.domain.session.controller.dto.response;

public record SessionLikeResponse(
    String message
) {
    public static SessionLikeResponse liked() {
        return new SessionLikeResponse("세션을 찜 목록에 추가했습니다.");
    }

    public static SessionLikeResponse unliked() {
        return new SessionLikeResponse("세션 찜을 취소했습니다.");
    }
}
