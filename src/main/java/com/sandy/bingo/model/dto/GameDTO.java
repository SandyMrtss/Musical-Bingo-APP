package com.sandy.bingo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class GameDTO {
    private Integer id;
    private String theme;
    private boolean isPlayed;
    private LocalDateTime playedDate;
    private List<SongDTO> songs;
    private List<RankingDTO> rankings;

}
