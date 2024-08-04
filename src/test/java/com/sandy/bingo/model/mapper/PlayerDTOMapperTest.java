package com.sandy.bingo.model.mapper;

import com.sandy.bingo.model.domain.Player;
import com.sandy.bingo.model.dto.PlayerDTO;
import com.sandy.bingo.model.dto.request.PlayerDTORequest;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerDTOMapperTest {

    private PlayerDTOMapper mapper = new PlayerDTOMapperImpl();
    private static EasyRandom easyRandom;

    @BeforeAll
    static void setup(){
        EasyRandomParameters parameters = new EasyRandomParameters()
                .stringLengthRange(5,10)
                .collectionSizeRange(1, 1);
        easyRandom = new EasyRandom(parameters);
    }

    @Test
    void mapFromDTO(){
        PlayerDTORequest playerDTORequest = easyRandom.nextObject(PlayerDTORequest.class);
        Player player = mapper.map(playerDTORequest);
        assertEquals(playerDTORequest.getFirstName(), player.getFirstName());
        assertEquals(playerDTORequest.getLastName(), player.getLastName());
        assertEquals(playerDTORequest.getUsername(), player.getUsername());
    }

    @Test
    void mapToDTO(){
        Player player = easyRandom.nextObject(Player.class);
        PlayerDTO playerDTO = mapper.map(player);
        assertEquals(player.getFirstName(), playerDTO.getFirstName());
        assertEquals(player.getLastName(), playerDTO.getLastName());
        assertEquals(player.getUsername(), playerDTO.getUsername());
    }
}
