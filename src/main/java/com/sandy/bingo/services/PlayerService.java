package com.sandy.bingo.services;

import com.sandy.bingo.model.domain.Player;
import com.sandy.bingo.model.dto.PlayerDTO;
import com.sandy.bingo.model.dto.request.PlayerDTORequest;

import java.util.List;

public interface PlayerService {
    PlayerDTO createPlayer(PlayerDTORequest playerDTORequest);
    PlayerDTO updatePlayer(Integer id, PlayerDTORequest playerDTORequest);
    PlayerDTO getPlayerDTO(Integer id);
    List<PlayerDTO> getAllPLayersDTO();
    PlayerDTO deletePlayer(Integer id);

}
