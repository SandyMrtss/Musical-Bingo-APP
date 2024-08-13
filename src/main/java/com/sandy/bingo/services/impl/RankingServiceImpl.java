package com.sandy.bingo.services.impl;

import com.sandy.bingo.model.domain.Game;
import com.sandy.bingo.model.domain.Ranking;
import com.sandy.bingo.model.domain.Player;
import com.sandy.bingo.model.dto.RankingDTO;
import com.sandy.bingo.model.mapper.PlayerDTOMapper;
import com.sandy.bingo.model.mapper.RankingDTOMapper;
import com.sandy.bingo.model.mapper.impl.PlayerDTOMapperImpl;
import com.sandy.bingo.model.mapper.impl.RankingDTOMapperImpl;
import com.sandy.bingo.repository.RankingRepository;
import com.sandy.bingo.services.RankingService;
import com.sandy.bingo.services.GameService;
import com.sandy.bingo.services.PlayerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RankingServiceImpl implements RankingService {

    private final RankingRepository rankingRepository;
    private final PlayerService playerService;
    private final GameService gameService;
    private final RankingDTOMapper rankingMapper = new RankingDTOMapperImpl();
    private final PlayerDTOMapper playerMapper = new PlayerDTOMapperImpl();

    public RankingServiceImpl(RankingRepository rankingRepository, PlayerService playerService, GameService gameService){
        this.rankingRepository = rankingRepository;
        this.playerService = playerService;
        this.gameService = gameService;
    }

    @Override
    public void addRanking(Integer gameId, Integer playerId) {
        Game game = gameService.getGame(gameId);
        Player player = playerService.getPlayer(playerId);
        Ranking ranking = new Ranking(game, player);
        rankingRepository.save(ranking);
    }

    @Override
    public void updatePosition(Integer gameId, Integer playerId, Integer position) {
        Ranking ranking = getRanking(gameId, playerId);
        ranking.setPosition(position);
        rankingRepository.save(ranking);
    }

    @Override
    public void updateIsLine(Integer gameId, Integer playerId, Boolean isLine) {
        Ranking ranking = getRanking(gameId, playerId);
        ranking.setIsLine(isLine);
        rankingRepository.save(ranking);
    }

    @Override
    public RankingDTO getRankingDTO(Integer gameId, Integer playerId) {
        Ranking ranking = getRanking(gameId, playerId);
        return rankingMapper.map(ranking, playerMapper.map(ranking.getPlayer()));
    }

    @Override
    public void deleteRanking(Integer gameId, Integer playerId) {
        Ranking ranking = getRanking(gameId, playerId);
        rankingRepository.delete(ranking);
    }

    @Override
    public List<RankingDTO> getAllRankingsDTOByGame(Integer gameId) {
        List<Ranking> rankings = getAllRankingsByGame(gameId);
        List<RankingDTO> rankingDTOs = new ArrayList<>();
        rankings.forEach(r ->
                rankingDTOs.add(rankingMapper.map(r, playerMapper.map(r.getPlayer()))));
        return rankingDTOs;    }

    @Override
    public List<RankingDTO> getAllRankingsDTOByPlayer(Integer playerId) {
        List<Ranking> rankings = getAllRankingsByPlayer(playerId);
        List<RankingDTO> rankingDTOs = new ArrayList<>();
        rankings.forEach(r ->
                rankingDTOs.add(rankingMapper.map(r, playerMapper.map(r.getPlayer()))));
        return rankingDTOs;
    }

    @Override
    public Ranking getRanking(Integer gameId, Integer playerId){
        Optional<Ranking> ranking = rankingRepository.findRanking(gameId, playerId);
        if(ranking.isEmpty()){
            throw new EntityNotFoundException();
        }
        return ranking.get();
    }

    private List<Ranking> getAllRankingsByGame(Integer gameId){
        Optional<List<Ranking>> rankings = rankingRepository.findAllByGame(gameId);
        if(rankings.isEmpty()){
            throw new EntityNotFoundException();
        }
        return rankings.get();
    }

    private List<Ranking> getAllRankingsByPlayer(Integer playerId){
        Optional<List<Ranking>> rankings = rankingRepository.findAllByPlayer(playerId);
        if(rankings.isEmpty()){
            throw new EntityNotFoundException();
        }
        return rankings.get();
    }
}
