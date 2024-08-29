package com.sandy.bingo.services.impl;

import com.sandy.bingo.model.domain.*;
import com.sandy.bingo.model.dto.*;
import com.sandy.bingo.model.dto.request.*;
import com.sandy.bingo.model.mapper.GameDTOMapper;
import com.sandy.bingo.model.mapper.RankingDTOMapper;
import com.sandy.bingo.model.mapper.impl.GameDTOMapperImpl;
import com.sandy.bingo.model.mapper.impl.RankingDTOMapperImpl;
import com.sandy.bingo.repository.GameRepository;
import com.sandy.bingo.services.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final SongService songService;
    private final PlayerService playerService;
    private final GameDTOMapper gameMapper = new GameDTOMapperImpl();
    private final RankingDTOMapper rankingMapper = new RankingDTOMapperImpl();

    public GameServiceImpl(GameRepository gameRepository, PlayerService playerService, SongService songService, PlayerService playerService1){
        this.gameRepository = gameRepository;
        this.songService = songService;
        this.playerService = playerService1;
    }
    @Override
    public GameDTO createGame(GameDTORequest gameDTORequest) {
        Game game = gameMapper.map(gameDTORequest);
        return gameMapper.map(gameRepository.save(game), new ArrayList<>(), new ArrayList<>());
    }

    @Override
    public GameDTO updateGame(Integer id, GameDTORequest gameDTORequest) {
        Game game = getGame(id);
        game.updateFromDTORequest(gameDTORequest);
        gameRepository.save(game);
        return getGameDTO(id);
    }

    @Override
    public GameDTO startGame(Integer id) {
        Game game = getGame(id);
        game.playGame();
        gameRepository.save(game);
        return getGameDTO(id);
    }

    @Override
    public GameDTO getGameDTO(Integer id) {
        Game game = getGame(id);
        List<SongDTO> songs = getAllSongs(game);
        List<Ranking> rankings = game.getRankings();
        List<RankingDTO> rankingsDTO = new ArrayList<>();
        rankings.forEach(r -> rankingsDTO.add(rankingToDTO(r)));
        return gameMapper.map(game, songs, rankingsDTO);
    }

    @Override
    public GameDTO addSong(SongDTORequest songDTORequest, Integer gameId) {
        songService.createSong(songDTORequest, getGame(gameId));
        return getGameDTO(gameId);
    }

    @Override
    public List<SongDTO> getAllSongs(Game game) {
        return songService.getAllSongsGame(game);
    }

    @Override
    public GameDTO deleteGame(Integer id) {
        Game game = getGame(id);
        GameDTO gameDTO = getGameDTO(id);
        gameRepository.delete(game);
        return gameDTO;
    }

    @Override
    public Game getGame(Integer id){
        Optional<Game> game = gameRepository.findById(id);
        if(game.isEmpty()){
            throw new EntityNotFoundException();
        }
        return game.get();
    }

    @Override
    public List<GameBasicDTO> getAllGames() {
        List<Game> allGames = gameRepository.findAll();
        List<GameBasicDTO> allGamesDTO = new ArrayList<>();
        allGames.forEach(g -> allGamesDTO.add(gameMapper.map(g)));
        return allGamesDTO;
    }

    private RankingDTO rankingToDTO(Ranking ranking){
        PlayerDTO playerDTO = playerService.getPlayerDTO(ranking.getPlayer().getId());
        return rankingMapper.map(ranking, playerDTO);
    }

}
