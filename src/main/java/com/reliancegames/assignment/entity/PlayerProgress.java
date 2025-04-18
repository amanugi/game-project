package com.reliancegames.assignment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "player_progress")
public class PlayerProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @Column(name = "level")
    private int level;

    @Column(name = "rank")
    private String rank;

    // You can store different currency types separately
    @Column(name = "gold")
    private int gold;

    @Column(name = "cash")
    private int cash;

    @Column(name = "gem")
    private int gem;

    // For rewards, a simple string format (e.g., "Reward1:ID1,Reward2:ID2")
    @Column(name = "rewards")
    private String rewards;

    @Column(name = "last_active_time")
    private LocalDateTime lastActiveTime;

    @Column(name = "country")
    private String country;

    // Constructors
    public PlayerProgress() {}

    public PlayerProgress(Player player, int level, String rank, int gold, int cash, int gem,
                          String rewards, LocalDateTime lastActiveTime, String country) {
        this.player = player;
        this.level = level;
        this.rank = rank;
        this.gold = gold;
        this.cash = cash;
        this.gem = gem;
        this.rewards = rewards;
        this.lastActiveTime = lastActiveTime;
        this.country = country;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
    public String getRank() { return rank; }
    public void setRank(String rank) { this.rank = rank; }
    public int getGold() { return gold; }
    public void setGold(int gold) { this.gold = gold; }
    public int getCash() { return cash; }
    public void setCash(int cash) { this.cash = cash; }
    public int getGem() { return gem; }
    public void setGem(int gem) { this.gem = gem; }
    public String getRewards() { return rewards; }
    public void setRewards(String rewards) { this.rewards = rewards; }
    public LocalDateTime getLastActiveTime() { return lastActiveTime; }
    public void setLastActiveTime(LocalDateTime lastActiveTime) { this.lastActiveTime = lastActiveTime; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
}