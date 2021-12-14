package com.maplr.model.dto;

import com.maplr.model.Player;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {
    private long id;

    private String coach;

    private long year;

    private List<Player> players;
}
