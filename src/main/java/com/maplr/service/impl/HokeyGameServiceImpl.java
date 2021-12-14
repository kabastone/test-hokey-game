package com.maplr.service.impl;

import com.maplr.model.Player;
import com.maplr.model.Team;
import com.maplr.model.dto.PlayerDto;
import com.maplr.repository.PlayerRepository;
import com.maplr.repository.TeamRepository;
import com.maplr.service.HokeyGameService;
import org.springframework.stereotype.Service;

@Service
public class HokeyGameServiceImpl implements HokeyGameService {
    private final TeamRepository teamRepository;

    private final PlayerRepository playerRepository;

    public HokeyGameServiceImpl(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public Team getTeamByYear(long year) {
        return teamRepository.findTeamByYear(year);
    }

    @Override
    public PlayerDto postPlayer(PlayerDto playerDto, long year) {
        //récupération du l'équipe de l'année
        Team team = teamRepository.findTeamByYear(year);
        Player player = new Player();
        player.setNumber(playerDto.getNumber());
        player.setName(playerDto.getName());
        player.setLastName(playerDto.getLastName());
        player.setPosition(playerDto.getPosition());
        player.setTeam(team);
        var p = playerRepository.save(player);
        return PlayerDto.builder()
                .number(p.getNumber())
                .name(p.getName())
                .lastName(p.getLastName())
                .position(p.getPosition())
                .isCaptain(p.isCaptain())
                .build();
    }

    @Override
    public PlayerDto putPlayer(long id) {
        var p = playerRepository.getById(id);
        p.setCaptain(true);
        var playerUpdated =  playerRepository.save(p);
        return PlayerDto.builder()
                .number(playerUpdated.getNumber())
                .name(playerUpdated.getName())
                .lastName(playerUpdated.getLastName())
                .position(playerUpdated.getPosition())
                .isCaptain(playerUpdated.isCaptain())
                .build();
    }
}
