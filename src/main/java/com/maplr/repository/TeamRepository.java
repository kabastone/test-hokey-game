package com.maplr.repository;

import com.maplr.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

   public Team findTeamByYear(long year);
}
