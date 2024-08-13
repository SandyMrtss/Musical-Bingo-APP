package com.sandy.bingo.model.mapper;

import com.sandy.bingo.model.domain.Ranking;
import com.sandy.bingo.model.dto.PlayerDTO;
import com.sandy.bingo.model.dto.RankingDTO;

public interface RankingDTOMapper {
    RankingDTO map(Ranking ranking, PlayerDTO playerDTO);
}
