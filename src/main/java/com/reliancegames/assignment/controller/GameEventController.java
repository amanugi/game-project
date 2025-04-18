package com.reliancegames.assignment.controller;

import com.reliancegames.assignment.entity.GameEvent;
import com.reliancegames.assignment.repository.GameEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class GameEventController {

    @Autowired
    private GameEventRepository gameEventRepository;

    // API: Schedule a new game event
    @PostMapping("/schedule")
    public GameEvent scheduleEvent(@RequestBody GameEvent event) {
        // Optionally add validations for start and end times
        return gameEventRepository.save(event);
    }

    // API: Update an existing game event
    @PutMapping("/update/{eventId}")
    public GameEvent updateEvent(@PathVariable Long eventId, @RequestBody GameEvent updatedEvent) {
        GameEvent event = gameEventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + eventId));
        event.setName(updatedEvent.getName());
        event.setStartTime(updatedEvent.getStartTime());
        event.setEndTime(updatedEvent.getEndTime());
        event.setConfiguration(updatedEvent.getConfiguration());
        return gameEventRepository.save(event);
    }

    // API: Get currently active events (valid events where current time is between start and end time)
    @GetMapping("/available")
    public List<GameEvent> getAvailableEvents() {
        LocalDateTime now = LocalDateTime.now();
        return gameEventRepository.findByStartTimeBeforeAndEndTimeAfter(now, now);
    }
}