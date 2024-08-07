package com.sandy.bingo.controllers;

import com.sandy.bingo.model.dto.PlayerDTO;
import com.sandy.bingo.model.dto.request.PlayerDTORequest;
import com.sandy.bingo.services.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:9000")
@RestController
@RequestMapping("/api/v1/bingoGame/players")
public class PlayerController {
    private PlayerService playerService;

    public PlayerController (PlayerService playerService){
        this.playerService = playerService;
    }

    @PostMapping("/newPlayer")
    public ResponseEntity<String> newPlayer(@RequestBody PlayerDTORequest playerDTORequest){
        playerService.createPlayer(playerDTORequest);
        return new ResponseEntity<>("Player added successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlayer(@PathVariable("id") Integer id, PlayerDTORequest playerDTORequest){
        playerService.updatePlayer(id, playerDTORequest);
        return new ResponseEntity<>("Player updated successfully", HttpStatus.OK);
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
    public ResponseEntity<String> deletePlayer(@PathVariable("id") Integer id) {
        playerService.deletePlayer(id);
        return new ResponseEntity<>("Player deleted successfully", HttpStatus.OK);
    }
}
