package com.sandy.bingo.model.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name= "players", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class Player {

}
