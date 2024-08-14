package com.sandy.bingo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RankingDTO {

    private PlayerDTO playerDTO;
    private Integer position;
    private Boolean isLine;
    private Integer points;
}
