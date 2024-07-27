package io.github.thehaleemnasir.olympic.games.analysis;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        /*
         * Get Teams from file
         */
        String filePath = "./assets/medals.txt";
        var teamResultList = FileParser.parseTeamResults(filePath);
        int teamCount = teamResultList.size();
        var message = "Found %s Teams".formatted(teamCount);
        System.out.println(message);
        /*
         *Start Service for Threads
         */
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(7);
        /*
         *Start Task Threads
         */
        Future<String> task1Future = executorService.submit(new Task1Callable(teamResultList, 4));
        executorService.scheduleWithFixedDelay(new Task2Runnable(teamResultList), 3, 5L, TimeUnit.SECONDS);
        Future<List<TeamResult>> task3Future = executorService.submit(new Task3Callable(teamResultList));
        Future<List<TeamResult>> task4Future = executorService.submit(new Task4Callable(teamResultList, 5, MedalType.Gold));
        /*
         * Collecting Futures
         */
        System.out.println(task1Future.get());
        System.out.println(task3Future.get());
        System.out.println(task4Future.get());
    }
}