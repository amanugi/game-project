package com.reliancegames.assignment.repository;

import com.reliancegames.assignment.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    // Additional lookup methods (e.g., findByDeviceId) can be added here if needed.
}