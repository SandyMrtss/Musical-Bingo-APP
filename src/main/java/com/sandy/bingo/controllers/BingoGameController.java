package com.sandy.bingo.controllers;

import com.sandy.bingo.model.dto.request.PlayerDTORequest;
import com.sandy.bingo.services.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:9000")
@RestController
@RequestMapping("/api/v1/bingoGame")
public class BingoGameController {
    private PlayerService playerService;

    public BingoGameController(PlayerService playerService){
        this.playerService = playerService;
    }


}
