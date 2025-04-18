package com.reliancegames.assignment.controller;

import com.reliancegames.assignment.entity.Player;
import com.reliancegames.assignment.entity.PlayerProgress;
import com.reliancegames.assignment.repository.PlayerRepository;
import com.reliancegames.assignment.repository.PlayerProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerProgressRepository playerProgressRepository;

    // API: Register a new player
    @PostMapping("/register")
    public Player registerPlayer(@RequestBody Player player) {
        // Set the creation date if it hasn't been provided
        if (player.getCreationDate() == null) {
            player.setCreationDate(LocalDateTime.now());
        }
        return playerRepository.save(player);
    }

    // API: Save or update player progression data
    @PostMapping("/{playerId}/progress")
    public PlayerProgress savePlayerProgress(@PathVariable Long playerId, @RequestBody PlayerProgress progress) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found with id: " + playerId));
        progress.setPlayer(player);
        // Update the last active time to now
        progress.setLastActiveTime(LocalDateTime.now());
        return playerProgressRepository.save(progress);
    }
}