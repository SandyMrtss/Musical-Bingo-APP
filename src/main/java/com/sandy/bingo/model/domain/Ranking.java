package com.sandy.bingo.model.domain;

import com.sandy.bingo.utils.BingoAppUtils;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Rankings")
public class Ranking {
    @EmbeddedId
    private RankingKey id = new RankingKey();
    @ManyToOne
    @MapsId("gameId")
    @JoinColumn(name= "game_id")
    private Game game;

    @ManyToOne
    @MapsId("playerId")
    @JoinColumn(name = "player_id")
    private Player player;

    private Integer position;
    private Boolean isLine;
    private Integer points;

    public Ranking(Game game, Player player){
        this.game = game;
        this.player = player;
        this.isLine = false;
    }

    public void setIsLine(Boolean isLine){
        this.isLine = isLine;
        if(Objects.nonNull(this.position)){
            setPoints(BingoAppUtils.calculatePoints(this.position, this.isLine));
        }
    }

    public void setPosition(Integer position){
        this.position = position;
        if(Objects.nonNull(this.position)){
            setPoints(BingoAppUtils.calculatePoints(this.position, this.isLine));
        }
    }

}
