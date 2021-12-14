package com.maplr.service;

import com.maplr.model.Team;
import com.maplr.model.dto.PlayerDto;

/**
 * Service pour la gestion du HokeyGame
 */
public interface HokeyGameService {
    /**
     * méthod qui permet de récupérer un team suivant l'année en paramètre
     * @param year
     * @return Team
     */
    Team getTeamByYear(long year);

    /**
     * Méthod qui permet de créer un player
     * @param playerDto
     * @return PlayerDto
     */
    PlayerDto postPlayer(PlayerDto playerDto, long year);

    PlayerDto putPlayer(long id);
}
