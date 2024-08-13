package com.sandy.bingo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class GameDTO {
    private Integer id;
    private String theme;
    private boolean isPlayed;
    private Date playedDate;
    private List<SongDTO> songs;
    private List<RankingDTO> players;

}
