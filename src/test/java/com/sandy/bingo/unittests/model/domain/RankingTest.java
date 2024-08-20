package com.sandy.bingo.unittests.model.domain;

import com.sandy.bingo.model.domain.Game;
import com.sandy.bingo.model.domain.Player;
import com.sandy.bingo.model.domain.Ranking;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankingTest {
    @Test
    void testSetIsLine() {
        Ranking ranking = new Ranking(new Game(), new Player());
        assertFalse(ranking.getIsLine());
        ranking.setIsLine(true);
        assertTrue(ranking.getIsLine());
        ranking.setIsLine(false);
        assertFalse(ranking.getIsLine());
        assertNull(ranking.getPoints());
        ranking.setPosition(1);
        assertNotNull(ranking.getPoints());
    }

    @Test
    void testSetPosition(){
        Ranking ranking = new Ranking(new Game(), new Player());
        ranking.setPosition(1);
        assertEquals(1, ranking.getPosition());
        assertNotNull(ranking.getPoints());
    }
}
