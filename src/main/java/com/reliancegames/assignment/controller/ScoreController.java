package com.reliancegames.assignment.controller;

import com.reliancegames.assignment.entity.Score;
import com.reliancegames.assignment.entity.Player;
import com.reliancegames.assignment.repository.ScoreRepository;
import com.reliancegames.assignment.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/scores")
public class ScoreController {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private PlayerRepository playerRepository;

    // API: Submit a new score
    @PostMapping("/submit")
    public Score submitScore(@RequestParam Long playerId,
                             @RequestParam String gameId,
                             @RequestParam int scoreValue) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found with id: " + playerId));
        Score score = new Score(player, gameId, scoreValue, LocalDateTime.now());
        return scoreRepository.save(score);
    }

    // API: Get top X players globally for a given gameId
    @GetMapping("/top/global")
    public List<Score> getTopPlayersGlobal(@RequestParam String gameId,
                                           @RequestParam(defaultValue = "10") int limit) {
        return scoreRepository.findByGameIdOrderByScoreDesc(gameId, PageRequest.of(0, limit));
    }

    // API: Get top X players by country for a given gameId
    @GetMapping("/top/country")
    public List<Score> getTopPlayersByCountry(@RequestParam String gameId,
                                              @RequestParam String country,
                                              @RequestParam(defaultValue = "10") int limit) {
        return scoreRepository.findByGameIdAndPlayer_CountryOrderByScoreDesc(gameId, country, PageRequest.of(0, limit));
    }
}