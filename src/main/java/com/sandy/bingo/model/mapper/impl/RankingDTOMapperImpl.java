package com.sandy.bingo.model.mapper.impl;

import com.sandy.bingo.model.domain.Ranking;
import com.sandy.bingo.model.dto.PlayerDTO;
import com.sandy.bingo.model.dto.RankingDTO;
import com.sandy.bingo.model.mapper.RankingDTOMapper;

public class RankingDTOMapperImpl implements RankingDTOMapper {

    @Override
    public RankingDTO map(Ranking ranking, PlayerDTO playerDTO) {
        return new RankingDTO(playerDTO, ranking.getPosition(), ranking.getIsLine(), ranking.getPoints());
    }
}
