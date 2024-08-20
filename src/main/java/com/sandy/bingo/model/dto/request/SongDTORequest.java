package com.sandy.bingo.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SongDTORequest {
    private String title;
    private String author;
    private String link;
}
