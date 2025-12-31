package com.runfit.domain.session.repository;

import com.runfit.domain.session.controller.dto.response.SessionListResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface SessionLikeRepositoryCustom {

    Slice<SessionListResponse> findLikedSessionsByUserId(Long userId, Pageable pageable);
}
