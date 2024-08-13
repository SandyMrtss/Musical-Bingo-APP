package com.sandy.bingo.model.domain;

import com.sandy.bingo.model.dto.request.GameDTORequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@Table(name = "games", uniqueConstraints = @UniqueConstraint(columnNames = "theme"))
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String theme;
    private boolean isPlayed;
    private Date playedDate;
    @OneToMany(mappedBy = "game")
    private List<Song> songs;
    @OneToMany(mappedBy = "game")
    private List<Ranking> rankings;

    public Game(String theme){
        this.isPlayed = false;
        this.theme = theme;
        this.songs = new ArrayList<>();
        this.rankings = new ArrayList<>();
    }

    public void playGame(){
        this.isPlayed = true;
        this.playedDate = Date.from(Instant.now());
    }

    public void updateFromDTORequest(GameDTORequest gameDTORequest){
        this.theme = gameDTORequest.getTheme();
    }
}
