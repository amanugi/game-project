CREATE DATABASE reliance_gamedb;
USE reliance_gamedb;

CREATE TABLE players (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  device_id VARCHAR(255) NOT NULL UNIQUE,
  username VARCHAR(255) NOT NULL,
  platform VARCHAR(100) NOT NULL,
  creation_date DATETIME NOT NULL
);

CREATE TABLE player_progress (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  player_id BIGINT NOT NULL,
  level INT,
  rank VARCHAR(100),
  gold INT,
  cash INT,
  gem INT,
  rewards VARCHAR(500),
  last_active_time DATETIME,
  country VARCHAR(100),
  FOREIGN KEY (player_id) REFERENCES players(id)
);

CREATE TABLE scores (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  player_id BIGINT NOT NULL,
  game_id VARCHAR(255) NOT NULL,
  score INT NOT NULL,
  timestamp DATETIME NOT NULL,
  FOREIGN KEY (player_id) REFERENCES players(id)
);

CREATE TABLE game_events (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  start_time DATETIME NOT NULL,
  end_time DATETIME NOT NULL,
  configuration TEXT
);