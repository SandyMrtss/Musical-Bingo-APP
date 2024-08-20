package com.sandy.bingo.unittests.model.mapper;

import com.sandy.bingo.model.domain.Game;
import com.sandy.bingo.model.dto.GameDTO;
import com.sandy.bingo.model.dto.RankingDTO;
import com.sandy.bingo.model.dto.SongDTO;
import com.sandy.bingo.model.dto.request.GameDTORequest;
import com.sandy.bingo.model.mapper.GameDTOMapper;
import com.sandy.bingo.model.mapper.impl.GameDTOMapperImpl;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameDTOMapperTest {

    private final GameDTOMapper mapper = new GameDTOMapperImpl();
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
        Game game = easyRandom.nextObject(Game.class);
        List<SongDTO> songs = new ArrayList<>();
        List<RankingDTO> rankings = new ArrayList<>();
        songs.add(easyRandom.nextObject(SongDTO.class));
        rankings.add(easyRandom.nextObject(RankingDTO.class));

        GameDTO gameDTO = mapper.map(game, songs, rankings);

        assertEquals(game.getId(), gameDTO.getId());
        assertEquals(game.getTheme(), gameDTO.getTheme());
        assertEquals(game.isPlayed(), gameDTO.isPlayed());
        assertEquals(game.getPlayedDate(), gameDTO.getPlayedDate());
        assertEquals(songs, gameDTO.getSongs());
        assertEquals(rankings, gameDTO.getRankings());

    }

    @Test
    void testMapFromDTO(){
        GameDTORequest gameDTORequest = easyRandom.nextObject(GameDTORequest.class);
        Game game = mapper.map(gameDTORequest);

        assertEquals(gameDTORequest.getTheme(), game.getTheme());
        assertFalse(game.isPlayed());
        assertNull(game.getPlayedDate());
        assertEquals(0, game.getSongs().size());
        assertEquals(0, game.getRankings().size());
    }
}
