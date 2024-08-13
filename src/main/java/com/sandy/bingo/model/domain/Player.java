package com.sandy.bingo.model.domain;

import com.sandy.bingo.model.dto.request.PlayerDTORequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@Entity
@NoArgsConstructor
@Table (name= "players", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    @OneToMany(mappedBy = "player")
    private List<Ranking> rankings;

    public Player(String firstName, String lastName, String username){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.rankings = new ArrayList<>();
    }

    public void updateFromDTORequest(PlayerDTORequest playerDTORequest){
        this.firstName = playerDTORequest.getFirstName();
        this.lastName = playerDTORequest.getLastName();
        this.username = playerDTORequest.getUsername();
    }
}
