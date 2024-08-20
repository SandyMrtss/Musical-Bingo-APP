package com.sandy.bingo.unittests.model.domain;

import com.sandy.bingo.model.domain.Game;
import com.sandy.bingo.model.dto.request.GameDTORequest;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    void testPlayGame(){
        Game game = new Game("theme");

        assertFalse(game.isPlayed());
        assertNull(game.getPlayedDate());

        game.playGame();

        assertTrue(game.isPlayed());
        assertEquals(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS), game.getPlayedDate().truncatedTo(ChronoUnit.SECONDS));
    }

    @Test
    void testUpdateFromDTORequest(){
        Game game = new Game("potato");
        GameDTORequest gameDTORequest= new GameDTORequest("potato-eh");
        game.updateFromDTORequest(gameDTORequest);
        assertEquals("potato-eh", game.getTheme());
    }
}
