package com.runfit.domain.session.repository;

import com.runfit.domain.session.entity.Session;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SessionRepository extends JpaRepository<Session, Long>, SessionRepositoryCustom {

    @Query("SELECT s FROM Session s WHERE s.id = :id AND s.deleted IS NULL")
    Optional<Session> findByIdAndNotDeleted(@Param("id") Long id);

    @Query("SELECT s FROM Session s " +
        "JOIN FETCH s.crew " +
        "JOIN FETCH s.hostUser " +
        "WHERE s.id = :id AND s.deleted IS NULL")
    Optional<Session> findByIdWithCrewAndHostUser(@Param("id") Long id);
}
