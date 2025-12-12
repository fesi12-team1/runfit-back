package com.runfit.domain.session.controller.dto.request;

import jakarta.validation.constraints.NotBlank;

public record SessionUpdateRequest(
    @NotBlank(message = "세션명은 필수입니다.")
    String name,

    String description,

    String image
) {
}
