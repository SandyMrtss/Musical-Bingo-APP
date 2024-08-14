package com.sandy.bingo.unittests.model.mapper;

import com.sandy.bingo.model.domain.Ranking;
import com.sandy.bingo.model.dto.PlayerDTO;
import com.sandy.bingo.model.dto.RankingDTO;
import com.sandy.bingo.model.mapper.RankingDTOMapper;
import com.sandy.bingo.model.mapper.impl.RankingDTOMapperImpl;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RankingDTOMapperTest {

    private final RankingDTOMapper mapper = new RankingDTOMapperImpl();
    private static EasyRandom easyRandom;

    @BeforeAll
    static void setup(){
        EasyRandomParameters parameters = new EasyRandomParameters()
                .stringLengthRange(5,10)
                .collectionSizeRange(1, 1)
                .excludeField(FieldPredicates.named("points"));
        easyRandom = new EasyRandom(parameters);
    }

    @Test
    void testMapToDTO(){
        Ranking ranking = easyRandom.nextObject(Ranking.class);
        PlayerDTO playerDTO = easyRandom.nextObject(PlayerDTO.class);
        RankingDTO rankingDTO = mapper.map(ranking, playerDTO);

        assertEquals(playerDTO, rankingDTO.getPlayerDTO());
        assertEquals(ranking.getPosition(), rankingDTO.getPosition());
        assertEquals(ranking.getIsLine(), rankingDTO.getIsLine());
        assertEquals(ranking.getPoints(), rankingDTO.getPoints());
    }

    @Test
    void testMapToDTOWithNull(){
        Ranking ranking = easyRandom.nextObject(Ranking.class);
        ranking.setPosition(null);
        PlayerDTO playerDTO = easyRandom.nextObject(PlayerDTO.class);
        RankingDTO rankingDTO = mapper.map(ranking, playerDTO);

        assertEquals(playerDTO, rankingDTO.getPlayerDTO());
        assertEquals(ranking.getPosition(), rankingDTO.getPosition());
        assertEquals(ranking.getIsLine(), rankingDTO.getIsLine());
        assertEquals(ranking.getPoints(), rankingDTO.getPoints());
    }

}
