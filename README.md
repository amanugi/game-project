# Game Backend API

## How to Run

1. Create DB `game_db`
2. Run `./gradlew bootRun`
3. ./gradlew build
   java -jar build/libs/game-backend-0.0.1-SNAPSHOT.jar


## APIs
- POST /api/users/register
- POST /api/users/{id}/progress
- POST /api/scores/submit
- GET /api/scores/top
- GET /api/scores/top-by-country