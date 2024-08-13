package com.sandy.bingo.controllers;

import com.sandy.bingo.model.dto.PlayerDTO;
import com.sandy.bingo.model.dto.request.PlayerDTORequest;
import com.sandy.bingo.services.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:9000", "http://localhost:4200"})
@RestController
@RequestMapping("/api/v1/bingoGame/players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController (PlayerService playerService){
        this.playerService = playerService;
    }

    @PutMapping("/newPlayer")
    public ResponseEntity<PlayerDTO> newPlayer(@RequestBody PlayerDTORequest playerDTORequest){
        PlayerDTO playerDTO = playerService.createPlayer(playerDTORequest);
        return new ResponseEntity<>(playerDTO , HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerDTO> updatePlayer(@PathVariable("id") Integer id, @RequestBody PlayerDTORequest playerDTORequest){
        System.out.println(playerDTORequest);
        PlayerDTO playerDTO = playerService.updatePlayer(id, playerDTORequest);
        return new ResponseEntity<>(playerDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDTO> getPlayer(@PathVariable("id") Integer id){
        PlayerDTO playerDTO = playerService.getPlayerDTO(id);
        return new ResponseEntity <>(playerDTO, HttpStatus.OK);
    }

    @GetMapping("/allPlayers")
    public ResponseEntity<List<PlayerDTO>> getAllPlayers(){
        List<PlayerDTO> playerDTOList = playerService.getAllPLayersDTO();
        return new ResponseEntity <>(playerDTOList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PlayerDTO> deletePlayer(@PathVariable("id") Integer id) {
        PlayerDTO playerDTO =  playerService.deletePlayer(id);
        return new ResponseEntity<>(playerDTO, HttpStatus.OK);
    }
}
