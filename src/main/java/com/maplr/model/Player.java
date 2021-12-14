package com.maplr.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Player {
    @Id
    private long  number;
    private String name;
    private String lastName;
    private String position;
    private boolean isCaptain;

    @ManyToOne
    private Team team;
}
