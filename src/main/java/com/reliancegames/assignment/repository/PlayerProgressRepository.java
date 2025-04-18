package com.reliancegames.assignment.repository;

import com.reliancegames.assignment.entity.PlayerProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerProgressRepository extends JpaRepository<PlayerProgress, Long> {
    // Custom queries can be added, if required.
}