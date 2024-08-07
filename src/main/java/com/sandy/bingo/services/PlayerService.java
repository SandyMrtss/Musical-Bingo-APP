package com.sandy.bingo.services;

import com.sandy.bingo.model.dto.PlayerDTO;
import com.sandy.bingo.model.dto.request.PlayerDTORequest;

import java.util.List;

public interface PlayerService {
    void createPlayer(PlayerDTORequest playerDTORequest);
    void updatePlayer(Integer id, PlayerDTORequest playerDTORequest);
    PlayerDTO getPlayerDTO(Integer id);
    List<PlayerDTO> getAllPLayersDTO();
    void deletePlayer(Integer id);

}
