package com.reliancegames.assignment.repository;

import com.reliancegames.assignment.entity.Score;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {

    // Fetch top scores for a specific game
    List<Score> findByGameIdOrderByScoreDesc(String gameId, Pageable pageable);

    // Fetch top scores by country for a specific game.
    // Here we leverage Spring Data JPA’s nested property (player.country)
    List<Score> findByGameIdAndPlayer_CountryOrderByScoreDesc(String gameId, String country, Pageable pageable);
}