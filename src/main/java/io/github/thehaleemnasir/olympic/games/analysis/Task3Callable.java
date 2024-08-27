package io.github.thehaleemnasir.olympic.games.analysis;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;


public class Task3Callable implements Callable<List<TeamResult>> {

    private final List<TeamResult> teamResultList;

    public Task3Callable(final List<TeamResult> teamResultList) {
        this.teamResultList = teamResultList;

    }

    @Override
    public List<TeamResult> call() throws Exception {
        return teamResultList.stream()
                .filter(teamResult -> teamResult.getName().toLowerCase().endsWith("stan") || teamResult.getName().toLowerCase().endsWith("lan"))
                .sorted(Comparator.comparing(TeamResult::getTotalRank))
                .toList();
    }
}
