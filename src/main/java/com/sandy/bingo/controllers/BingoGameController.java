package com.sandy.bingo.controllers;

import com.sandy.bingo.model.dto.GameBasicDTO;
import com.sandy.bingo.model.dto.GameDTO;
import com.sandy.bingo.services.GameService;
import com.sandy.bingo.services.PlayerService;
import com.sandy.bingo.services.RankingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin({"http://localhost:9000", "http://localhost:4200"})
@RestController
@RequestMapping("/api/v1/bingoGame")
public class BingoGameController {
    private final PlayerService playerService;
    private final GameService gameService;
    private final RankingService rankingService;

    public BingoGameController(PlayerService playerService, GameService gameService, RankingService rankingService){
        this.playerService = playerService;
        this.gameService = gameService;
        this.rankingService = rankingService;
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<GameDTO> getGame(@PathVariable("gameId") Integer gameId){
        GameDTO gameDTO = gameService.getGameDTO(gameId);
        return new ResponseEntity<>(gameDTO, HttpStatus.OK);
    }

    @GetMapping("/getAllGames")
    public ResponseEntity<List<GameBasicDTO>> getAllGames(){
        List<GameBasicDTO> gameDTOList = gameService.getAllGames();
        return new ResponseEntity<>(gameDTOList, HttpStatus.OK);
    }
}
