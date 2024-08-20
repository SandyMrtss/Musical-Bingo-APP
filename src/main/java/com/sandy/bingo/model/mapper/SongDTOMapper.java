package com.sandy.bingo.model.mapper;

import com.sandy.bingo.model.domain.Game;
import com.sandy.bingo.model.domain.Song;
import com.sandy.bingo.model.dto.SongDTO;
import com.sandy.bingo.model.dto.request.SongDTORequest;

public interface SongDTOMapper {
    SongDTO map(Song song);
    Song map(SongDTORequest songDTORequest, Game game);
}
