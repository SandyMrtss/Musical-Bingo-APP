package com.sandy.bingo.unittests.model.mapper;

import com.sandy.bingo.model.domain.Player;
import com.sandy.bingo.model.dto.PlayerDTO;
import com.sandy.bingo.model.dto.request.PlayerDTORequest;
import com.sandy.bingo.model.mapper.PlayerDTOMapper;
import com.sandy.bingo.model.mapper.impl.PlayerDTOMapperImpl;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerDTOMapperTest {

    private final PlayerDTOMapper mapper = new PlayerDTOMapperImpl();
    private static EasyRandom easyRandom;

    @BeforeAll
    static void setup(){
        EasyRandomParameters parameters = new EasyRandomParameters()
                .stringLengthRange(5,10)
                .collectionSizeRange(1, 1);
        easyRandom = new EasyRandom(parameters);
    }

    @Test
    void testMapFromDTORequest(){
        PlayerDTORequest playerDTORequest = easyRandom.nextObject(PlayerDTORequest.class);
        Player player = mapper.map(playerDTORequest);

        assertEquals(playerDTORequest.getFirstName(), player.getFirstName());
        assertEquals(playerDTORequest.getLastName(), player.getLastName());
        assertEquals(playerDTORequest.getUsername(), player.getUsername());
        assertEquals(0, player.getRankings().size());
    }

    @Test
    void testMapToDTO(){
        Player player = easyRandom.nextObject(Player.class);
        PlayerDTO playerDTO = mapper.map(player);

        assertEquals(player.getId(), playerDTO.getId());
        assertEquals(player.getFirstName(), playerDTO.getFirstName());
        assertEquals(player.getLastName(), playerDTO.getLastName());
        assertEquals(player.getUsername(), playerDTO.getUsername());
    }
}
