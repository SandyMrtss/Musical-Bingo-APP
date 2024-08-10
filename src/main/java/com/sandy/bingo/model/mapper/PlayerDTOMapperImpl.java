package com.sandy.bingo.model.mapper;

import com.sandy.bingo.model.domain.Player;
import com.sandy.bingo.model.dto.PlayerDTO;
import com.sandy.bingo.model.dto.request.PlayerDTORequest;

public class PlayerDTOMapperImpl implements PlayerDTOMapper {
    @Override
    public PlayerDTO map(Player player) {
        return new PlayerDTO(player.getId().toString() ,player.getFirstName(), player.getLastName(), player.getUsername());
    }

    @Override
    public Player map(PlayerDTORequest playerDTORequest) {
        return new Player(playerDTORequest.getFirstName(), playerDTORequest.getLastName(), playerDTORequest.getUsername());
    }
}
