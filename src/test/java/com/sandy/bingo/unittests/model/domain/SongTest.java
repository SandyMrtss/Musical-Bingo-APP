package com.sandy.bingo.unittests.model.domain;

import com.sandy.bingo.model.domain.Game;
import com.sandy.bingo.model.domain.Song;
import com.sandy.bingo.model.dto.request.SongDTORequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SongTest {

    @Test
    void testUpdateFromDTORequest(){
        Integer id = 1;
        String title = "lololo";
        String author = "Mr Bean";
        Song song = new Song(id, title, author, null, new Game());
        SongDTORequest songDTORequest = new SongDTORequest("lalala", "Mr. Bean", null);
        song.updateFromDTORequest(songDTORequest);

        assertEquals(id, song.getId());
        assertEquals("lalala", song.getTitle());
        assertEquals("Mr. Bean", song.getAuthor());
        assertNull(song.getLink());
    }
}
