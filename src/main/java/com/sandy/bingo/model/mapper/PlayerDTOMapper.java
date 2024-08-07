package com.sandy.bingo.model.mapper;

import com.sandy.bingo.model.domain.Player;
import com.sandy.bingo.model.dto.PlayerDTO;
import com.sandy.bingo.model.dto.request.PlayerDTORequest;

public interface PlayerDTOMapper {
    PlayerDTO map(Player player);
    Player map(PlayerDTORequest playerDTORequest);
}
