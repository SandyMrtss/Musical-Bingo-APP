package com.sandy.bingo.model.mapper.impl;

import com.sandy.bingo.model.domain.Game;
import com.sandy.bingo.model.dto.GameDTO;
import com.sandy.bingo.model.dto.RankingDTO;
import com.sandy.bingo.model.dto.SongDTO;
import com.sandy.bingo.model.dto.request.GameDTORequest;
import com.sandy.bingo.model.mapper.GameDTOMapper;

import java.util.List;

public class GameDTOMapperImpl implements GameDTOMapper {
    @Override
    public GameDTO map(Game game, List<SongDTO> songs, List<RankingDTO> players) {
        return new GameDTO(game.getId(), game.getTheme(), game.isPlayed(), game.getPlayedDate(), songs, players);
    }

    @Override
    public Game map(GameDTORequest gameDTORequest) {
        return new Game(gameDTORequest.getTheme());
    }

}
