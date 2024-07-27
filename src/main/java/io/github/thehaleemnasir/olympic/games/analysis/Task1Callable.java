package io.github.thehaleemnasir.olympic.games.analysis;

import java.util.List;
import java.util.concurrent.Callable;

public class Task1Callable implements Callable<String> {
    private final List<TeamResult> teamResultList;
    private final int precision;

    public Task1Callable(List<TeamResult> teamResultList, int precision) {

        this.teamResultList = teamResultList;
        this.precision = precision;
    }

    @Override
    public String call() throws Exception {
        List<TeamResult> filterTeamResults = teamResultList.stream()
                .filter(teamResult -> teamResult.getGoldRank() > teamResult.getTotalRank())
                .toList();
        double percentage = filterTeamResults.size() * 100 / (double) teamResultList.size();

        var message = "Percentage of those countries whose Gold Rank is greater than their Total Rank : %." + precision + "f%%";
        return String.format(message, percentage);
    }
}
