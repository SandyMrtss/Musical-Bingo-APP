package com.sandy.bingo.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerDTORequest {
    private String firstName;
    private String lastName;
    private String username;

}
