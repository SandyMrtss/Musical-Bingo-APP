package com.sandy.bingo.unittests.model.mapper;

import com.sandy.bingo.model.domain.Game;
import com.sandy.bingo.model.domain.Song;
import com.sandy.bingo.model.dto.SongDTO;
import com.sandy.bingo.model.dto.request.SongDTORequest;
import com.sandy.bingo.model.mapper.SongDTOMapper;
import com.sandy.bingo.model.mapper.impl.SongDTOMapperImpl;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SongDTOMapperTest {

    private final SongDTOMapper mapper = new SongDTOMapperImpl();
    private static EasyRandom easyRandom;

    @BeforeAll
    static void setup(){
        EasyRandomParameters parameters = new EasyRandomParameters()
                .stringLengthRange(5,10)
                .collectionSizeRange(1, 1);
        easyRandom = new EasyRandom(parameters);
    }

    @Test
    void testMapToDTO(){
        Song song = easyRandom.nextObject(Song.class);
        SongDTO songDTO = mapper.map(song);

        assertEquals(song.getId(), songDTO.getId());
        assertEquals(song.getTitle(), songDTO.getTitle());
        assertEquals(song.getAuthor(), songDTO.getAuthor());
        assertEquals(song.getLink(), songDTO.getLink());
    }

    @Test
    void testMapFromDTO(){
        SongDTORequest songDTORequest = easyRandom.nextObject(SongDTORequest.class);
        Game game = easyRandom.nextObject(Game.class);
        Song song = mapper.map(songDTORequest, game);

        assertEquals(songDTORequest.getTitle(), song.getTitle());
        assertEquals(songDTORequest.getAuthor(), song.getAuthor());
        assertEquals(songDTORequest.getLink(), song.getLink());
        assertEquals(game, song.getGame());
    }

}
