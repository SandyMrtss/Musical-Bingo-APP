package com.sandy.bingo.model.mapper.impl;

import com.sandy.bingo.model.domain.Game;
import com.sandy.bingo.model.domain.Song;
import com.sandy.bingo.model.dto.SongDTO;
import com.sandy.bingo.model.dto.request.SongDTORequest;
import com.sandy.bingo.model.mapper.SongDTOMapper;


public class SongDTOMapperImpl implements SongDTOMapper {
    @Override
    public SongDTO map(Song song) {
        return new SongDTO(song.getId(), song.getTitle(), song.getAuthor(), song.getLink());
    }

    @Override
    public Song map(SongDTORequest songDTORequest, Game game) {
        return new Song(null, songDTORequest.getTitle(), songDTORequest.getAuthor(), songDTORequest.getLink(), game);
    }
}
