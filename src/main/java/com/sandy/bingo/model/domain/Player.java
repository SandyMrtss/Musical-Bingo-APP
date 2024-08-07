package com.sandy.bingo.model.domain;

import com.sandy.bingo.model.dto.request.PlayerDTORequest;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name= "players", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String username;

    public Player(String firstName, String lastName, String username){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
    }

    public void updateFromDTORequest(PlayerDTORequest playerDTORequest){
        this.firstName = playerDTORequest.getFirstName();
        this.lastName = playerDTORequest.getLastName();
        this.username = playerDTORequest.getUsername();
    }
}
