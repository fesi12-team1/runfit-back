package com.runfit.domain.session.controller.dto.response;

public record SessionJoinResponse(
    String message,
    Long currentParticipantCount,
    Integer maxParticipantCount
) {
    public static SessionJoinResponse joined(long currentCount, int maxCount) {
        return new SessionJoinResponse(
            "세션에 참가 신청이 완료되었습니다.",
            currentCount,
            maxCount
        );
    }

    public static SessionJoinResponse cancelled(long currentCount) {
        return new SessionJoinResponse(
            "세션 참여가 취소되었습니다.",
            currentCount,
            null
        );
    }
}
