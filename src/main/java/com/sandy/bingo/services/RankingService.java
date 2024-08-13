package com.sandy.bingo.services;

import com.sandy.bingo.model.domain.Ranking;
import com.sandy.bingo.model.dto.RankingDTO;

import java.util.List;

public interface RankingService {
    void addRanking(Integer gameId, Integer playerId);
    void updatePosition(Integer gameId, Integer playerId, Integer position);
    void updateIsLine(Integer gameId, Integer playerId, Boolean isLine);
    RankingDTO getRankingDTO(Integer gameId, Integer playerId);
    void deleteRanking(Integer gameId, Integer playerId);
    List<RankingDTO> getAllRankingsDTOByGame(Integer gameId);
    List<RankingDTO> getAllRankingsDTOByPlayer(Integer playerId);
    Ranking getRanking(Integer gameId, Integer playerId);

}
