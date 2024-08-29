package com.sandy.bingo.model.mapper;

import com.sandy.bingo.model.domain.Game;
import com.sandy.bingo.model.dto.GameBasicDTO;
import com.sandy.bingo.model.dto.GameDTO;
import com.sandy.bingo.model.dto.RankingDTO;
import com.sandy.bingo.model.dto.SongDTO;
import com.sandy.bingo.model.dto.request.GameDTORequest;

import java.util.List;

public interface GameDTOMapper {
    GameDTO map(Game game, List<SongDTO> songs, List<RankingDTO> players);
    Game map(GameDTORequest gameDTORequest);
    GameBasicDTO map (Game game);
}
