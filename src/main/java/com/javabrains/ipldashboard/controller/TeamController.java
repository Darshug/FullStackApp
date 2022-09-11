package com.javabrains.ipldashboard.controller;

import com.javabrains.ipldashboard.model.Match;
import com.javabrains.ipldashboard.model.Team;
import com.javabrains.ipldashboard.repository.MatchRepository;
import com.javabrains.ipldashboard.repository.TeamRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {

    private TeamRepository teamRepository;

    private MatchRepository matchRepository;

    private TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }


    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
        Team team = teamRepository.findByName(teamName);
        List<Match> matches=matchRepository.findLatestMatchesByTeam(teamName, 4);
        team.setMatches(matches);
        return team;
    }
}
