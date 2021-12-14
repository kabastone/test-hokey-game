package com.maplr.controller;

import com.maplr.model.Team;
import com.maplr.model.dto.PlayerDto;
import com.maplr.model.dto.TeamDto;
import com.maplr.service.HokeyGameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
public class HokeyGameController {

    private final HokeyGameService hokeyGameService;

    public HokeyGameController(HokeyGameService hokeyGameService) {
        this.hokeyGameService = hokeyGameService;
    }

    @GetMapping("/team/{year}")
    public ResponseEntity<Team> getTeamYear(@PathVariable("year") long year) {
        log.info("La team de l'année {} ", year);
        Team teamOfYear = hokeyGameService.getTeamByYear(year);
        if (teamOfYear != null) {
            TeamDto teamDto = TeamDto.builder()
                    .id(teamOfYear.getId())
                    .coach(teamOfYear.getCoach())
                    .year(teamOfYear.getYear())
                    .players(teamOfYear.getPlayers())
                    .build();
            log.info("La team : {} ", teamDto);
            return new ResponseEntity(teamDto, HttpStatus.OK);
        }
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/team/{year}")
    public ResponseEntity<PlayerDto> postPlayer(@PathVariable("year") long year, @RequestBody PlayerDto playerDto) {

        log.info("Création du joueur {} de l'année {} ", playerDto, year);
        var player = hokeyGameService.postPlayer(playerDto, year);
        if (player != null) {
            return new ResponseEntity(player, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/player/captain/{id}")
    public ResponseEntity<PlayerDto> putPlayer(@PathVariable("id") long id) {
        log.info("Update du joueur id {} ", id);
        var player = hokeyGameService.putPlayer(id);
        if (player != null) {
            return new ResponseEntity(player, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
