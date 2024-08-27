package io.github.thehaleemnasir.olympic.games.analysis;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Task2Runnable implements Runnable {
    private final List<TeamResult> teamResultList;

    public Task2Runnable(List<TeamResult> teamResultList) {

        this.teamResultList = teamResultList;
    }


    @Override
    public void run() {
        var min = 1;
        var max = 86;

        int randomGoldRankNumber = ThreadLocalRandom.current().nextInt(min, max + 1);

        var filteredList = teamResultList.stream()
                .filter(teamResult -> teamResult.getGoldRank() == randomGoldRankNumber)
                .toList();

        if (filteredList.isEmpty()) {
            System.out.println("No records found with a gold rank of " + randomGoldRankNumber);
        } else {
            filteredList.forEach(System.out::println);
        }

    }
}
