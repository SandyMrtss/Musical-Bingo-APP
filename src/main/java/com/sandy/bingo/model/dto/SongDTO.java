package com.sandy.bingo.model.dto;

import lombok.Data;

import java.util.Objects;

@Data
public class SongDTO {
    private Integer id;
    private String title;
    private String author;
    private String link;

    public SongDTO(Integer id, String title, String author, String link) {
        this.id = id;
        this.title = title;
        this.author = author;
        if(Objects.nonNull(link)){
            this.link = link;
        }
    }
}
