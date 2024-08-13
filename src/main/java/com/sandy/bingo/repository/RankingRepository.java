package com.sandy.bingo.repository;

import com.sandy.bingo.model.domain.Ranking;
import com.sandy.bingo.model.domain.RankingKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, RankingKey> {
    @Query("SELECT r FROM Ranking r WHERE r.id.gameId = :gameId AND r.id.playerId = :playerId")
    Optional<Ranking> findRanking(Integer gameId, Integer playerId);
    @Query("SELECT r FROM Ranking r WHERE r.id.playerId = :playerId")
    Optional<List<Ranking>> findAllByPlayer(Integer playerId);
    @Query("SELECT r FROM Ranking r WHERE r.id.gameId = :gameId")
    Optional<List<Ranking>> findAllByGame(Integer gameId);
}
