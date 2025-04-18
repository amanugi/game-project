package com.reliancegames.assignment.repository;

import com.reliancegames.assignment.entity.GameEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface GameEventRepository extends JpaRepository<GameEvent, Long> {
    // Retrieve events that are "active" at the current time:
    List<GameEvent> findByStartTimeBeforeAndEndTimeAfter(LocalDateTime now1, LocalDateTime now2);
}