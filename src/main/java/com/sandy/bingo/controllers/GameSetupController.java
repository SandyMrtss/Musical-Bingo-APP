package com.sandy.bingo.controllers;

import com.sandy.bingo.model.dto.GameDTO;
import com.sandy.bingo.model.dto.request.GameDTORequest;
import com.sandy.bingo.model.dto.request.SongDTORequest;
import com.sandy.bingo.services.GameService;
import com.sandy.bingo.services.RankingService;
import com.sandy.bingo.services.SongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:9000", "http://localhost:4200"})
@RestController
@RequestMapping("/api/v1/bingoGame/setUp")
public class GameSetupController {
    private final SongService songService;
    private final GameService gameService;
    private final RankingService rankingService;

    public GameSetupController(SongService songService, GameService gameService, RankingService rankingService){
        this.songService = songService;
        this.gameService = gameService;
        this.rankingService = rankingService;
    }

    @PutMapping("newGame")
    public ResponseEntity<GameDTO> newGame(@RequestBody GameDTORequest gameDTORequest) {
        GameDTO gameDTO = gameService.createGame(gameDTORequest);
        return new ResponseEntity<>(gameDTO , HttpStatus.OK);
    }

    @PutMapping("{gameId}")
    public ResponseEntity<GameDTO> updateGame(@PathVariable("gameId") Integer gameId, @RequestBody GameDTORequest gameDTORequest) {
        GameDTO gameDTO = gameService.updateGame(gameId, gameDTORequest);
        return new ResponseEntity<>(gameDTO , HttpStatus.OK);
    }

    @DeleteMapping("{gameId}")
    public ResponseEntity<GameDTO> deleteGame(@PathVariable("gameId") Integer gameId) {
        GameDTO gameDTO = gameService.deleteGame(gameId);
        return new ResponseEntity<>(gameDTO , HttpStatus.OK);
    }

    @PutMapping("{gameId}/addSong")
    public ResponseEntity<GameDTO> addSong(@RequestBody SongDTORequest songDTORequest, @PathVariable("gameId") Integer id){
        GameDTO gameDTO = gameService.addSong(songDTORequest, id);
        return new ResponseEntity<>(gameDTO , HttpStatus.OK);
    }

    @PutMapping("{gameId}/songs/{songId}")
    public ResponseEntity<GameDTO> updateSong(@RequestBody SongDTORequest songDTORequest, @PathVariable("songId") Integer songId, @PathVariable("gameId") Integer gameId) {
        songService.updateSong(songId, songDTORequest);
        GameDTO gameDTO = gameService.getGameDTO(gameId);
        return new ResponseEntity<>(gameDTO, HttpStatus.OK);
    }

    @DeleteMapping("{gameId}/songs/{songId}")
    public ResponseEntity<GameDTO> deleteSong(@PathVariable("gameId") Integer gameId, @PathVariable("songId") Integer songId){
        songService.deleteSong(songId);
        GameDTO gameDTO = gameService.getGameDTO(gameId);
        return new ResponseEntity<>(gameDTO, HttpStatus.OK);
    }

    @PutMapping("{gameId}/players/addPlayer/{playerId}")
    public ResponseEntity<GameDTO> addPlayer(@PathVariable("gameId") Integer gameId, @PathVariable("playerId") Integer playerId) {
        rankingService.addRanking(gameId, playerId);
        GameDTO gameDTO = gameService.getGameDTO(gameId);
        return new ResponseEntity<>(gameDTO, HttpStatus.OK);
    }

    @DeleteMapping("{gameId}/players/{playerId}")
    public ResponseEntity<GameDTO> deletePlayer(@PathVariable("gameId") Integer gameId, @PathVariable("playerId") Integer playerId) {
        rankingService.deleteRanking(gameId, playerId);
        GameDTO gameDTO = gameService.getGameDTO(gameId);
        return new ResponseEntity<>(gameDTO, HttpStatus.OK);
    }




}
