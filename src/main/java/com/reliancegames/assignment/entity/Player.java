package com.reliancegames.assignment.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "device_id", unique = true, nullable = false)
    private String deviceId;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "platform", nullable = false)
    private String platform;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    // Constructors
    public Player() {}

    public Player(String deviceId, String username, String platform, LocalDateTime creationDate) {
        this.deviceId = deviceId;
        this.username = username;
        this.platform = platform;
        this.creationDate = creationDate;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }
    public LocalDateTime getCreationDate() { return creationDate; }
    public void setCreationDate(LocalDateTime creationDate) { this.creationDate = creationDate; }
}