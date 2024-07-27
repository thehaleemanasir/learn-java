package io.github.thehaleemnasir.olympic.games.analysis;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

public class Task4Callable implements Callable<List<TeamResult>>{

    final private List<TeamResult> teamResultList;
    private final int limit;
    private final MedalType sortKeyMedalType;

    public Task4Callable(final List<TeamResult> teamResultList, int limit, MedalType medalType)
    {
        this.teamResultList = teamResultList;

        this.limit = limit;
        this.sortKeyMedalType = medalType;
    }

    @Override
    public List<TeamResult> call() throws Exception {
       if (sortKeyMedalType == MedalType.Gold) {
          return teamResultList.stream()
                           .sorted(Comparator.comparing(TeamResult :: getGoldMedals))
                                   .limit(limit)
                                           .toList();

       }
        if silver
    }
}
