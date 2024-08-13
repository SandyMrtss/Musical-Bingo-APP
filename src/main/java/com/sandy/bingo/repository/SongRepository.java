package com.sandy.bingo.repository;

import com.sandy.bingo.model.domain.Game;
import com.sandy.bingo.model.domain.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {
    List<Song> findByGame(Game game);
}
