package com.runfit.domain.crew.repository;

import com.runfit.domain.crew.controller.dto.response.CrewListResponse;
import com.runfit.domain.crew.entity.Membership;
import com.runfit.domain.user.controller.dto.response.MyCrewResponse;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface MembershipRepositoryCustom {

    Slice<CrewListResponse> findOwnedCrewsByUserId(Long userId, Pageable pageable);

    Slice<MyCrewResponse> findMyCrewsByUserId(Long userId, Pageable pageable);

    List<Membership> findMembersByCrewIds(List<Long> crewIds);
}
