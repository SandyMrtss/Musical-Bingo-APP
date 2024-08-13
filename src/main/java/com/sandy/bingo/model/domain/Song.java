package com.sandy.bingo.model.domain;

import com.sandy.bingo.model.dto.request.SongDTORequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
@Table(name= "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String author;
    private String link;
    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    public Song(Integer id, String title, String author, String link, Game game){
        if(Objects.nonNull(id)){
            this.id = id;
        }
        this.title = title;
        this.author = author;
        if(Objects.nonNull(link)){
            this.link = link;
        }
        this.game = game;
    }

    public void updateFromDTORequest(SongDTORequest songDTORequest){
        this.title = songDTORequest.getTitle();
        this.author = songDTORequest.getAuthor();
        if(Objects.nonNull(songDTORequest.getLink())){
            this.link = songDTORequest.getLink();
        }
    }
}
