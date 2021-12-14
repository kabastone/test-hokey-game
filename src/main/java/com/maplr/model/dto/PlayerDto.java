package com.maplr.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto {
    private long  number;
    private String name;
    private String lastName;
    private String position;
    private boolean isCaptain;
}
