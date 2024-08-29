package com.sandy.bingo.services;

import com.sandy.bingo.model.domain.Game;
import com.sandy.bingo.model.domain.Player;
import com.sandy.bingo.model.dto.GameBasicDTO;
import com.sandy.bingo.model.dto.GameDTO;
import com.sandy.bingo.model.dto.SongDTO;
import com.sandy.bingo.model.dto.request.GameDTORequest;
import com.sandy.bingo.model.dto.request.SongDTORequest;

import java.util.List;

public interface GameService {
    GameDTO createGame(GameDTORequest gameDTORequest);
    GameDTO updateGame(Integer id, GameDTORequest gameDTORequest);
    GameDTO startGame(Integer id);
    GameDTO getGameDTO(Integer id);
    GameDTO addSong(SongDTORequest songDTORequest, Integer gameId);
    List<SongDTO> getAllSongs(Game game);
    GameDTO deleteGame(Integer id);
    Game getGame(Integer id);
    List<GameBasicDTO> getAllGames();

}
