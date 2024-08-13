package com.sandy.bingo.services;

import com.sandy.bingo.model.domain.Game;
import com.sandy.bingo.model.dto.SongDTO;
import com.sandy.bingo.model.dto.request.SongDTORequest;

import java.util.List;

public interface SongService {
    void createSong(SongDTORequest songDTORequest, Game game);
    void updateSong(Integer id, SongDTORequest songDTORequest);
    List<SongDTO> getAllSongsGame(Game game);
    void deleteSong(Integer id);

}
