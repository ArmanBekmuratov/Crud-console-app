package com.arman.crud.service;
import com.arman.crud.model.Team;
import com.arman.crud.model.TeamStatus;

import java.util.List;

public interface TeamService extends GenericService<Team>{
    Team save(String name, List<Integer> developerIds, TeamStatus teamStatus);

    Team update(Integer id,String name, List<Integer> developerIds, TeamStatus teamStatus);
}
