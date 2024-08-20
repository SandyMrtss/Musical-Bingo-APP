package com.sandy.bingo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PlayerDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
}
