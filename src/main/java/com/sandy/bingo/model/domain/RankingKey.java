package com.sandy.bingo.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class RankingKey implements Serializable {
    @Column(name = "game_id")
    private Integer gameId;

    @Column(name = "player_id")
    private Integer playerId;
}
