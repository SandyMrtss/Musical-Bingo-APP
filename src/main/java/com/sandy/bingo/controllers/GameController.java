package com.sandy.bingo.controllers;

import com.sandy.bingo.model.dto.GameDTO;
import com.sandy.bingo.services.GameService;
import com.sandy.bingo.services.RankingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin({"http://localhost:9000", "http://localhost:4200"})
@RestController
@RequestMapping("/api/v1/bingoGame/play/{gameId}")
public class GameController {
    private final GameService gameService;
    private final RankingService rankingService;

    public GameController(GameService gameService, RankingService rankingService){
        this.gameService = gameService;
        this.rankingService = rankingService;
    }

    @PutMapping("/start")
    public ResponseEntity<GameDTO> playGame(@PathVariable("gameId") Integer gameId) {
        GameDTO gameDTO = gameService.startGame(gameId);
        return new ResponseEntity<>(gameDTO , HttpStatus.OK);
    }

    @PutMapping("players/{playerId}")
    public ResponseEntity<GameDTO> updatePlayerPosition(@PathVariable("gameId") Integer gameId, @PathVariable("playerId") Integer playerId, @RequestParam Integer position) {
        rankingService.updatePosition(gameId, playerId, position);
        GameDTO gameDTO = gameService.getGameDTO(gameId);
        return new ResponseEntity<>(gameDTO, HttpStatus.OK);
    }
    @PutMapping("players/{playerId}/line")
    public ResponseEntity<GameDTO> updateLine(@PathVariable("gameId") Integer gameId, @PathVariable("playerId") Integer playerId, @RequestParam Boolean isLine){
        rankingService.updateIsLine(gameId, playerId, isLine);
        GameDTO gameDTO = gameService.getGameDTO(gameId);
        return new ResponseEntity<>(gameDTO, HttpStatus.OK);
    }

}
