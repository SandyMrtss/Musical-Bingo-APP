package com.sandy.bingo.unittests.model.domain;

import com.sandy.bingo.model.domain.Player;
import com.sandy.bingo.model.dto.request.PlayerDTORequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {
    String firstName = "Lola";
    String lastName = "López";
    String username = "lolo";
    @Test
    void testUpdateFromDTORequestWithAllChanges(){
        Player player = new Player(firstName, lastName, username);
        PlayerDTORequest playerDTORequest = new PlayerDTORequest("Loli", "Lopez", "lololo");
        player.updateFromDTORequest(playerDTORequest);
        assertEquals("Loli", player.getFirstName());
        assertEquals("Lopez", player.getLastName());
        assertEquals("lololo", player.getUsername());

    }

    @Test
    void testUpdateFromDTORequestWithSomeChanges(){

        Player player = new Player(firstName, lastName, username);
        PlayerDTORequest playerDTORequest = new PlayerDTORequest("loli", lastName, username);
        player.updateFromDTORequest(playerDTORequest);
        assertEquals("loli", player.getFirstName());
        assertEquals(lastName, player.getLastName());
        assertEquals(username, player.getUsername());

    }
}
