package io.github.thehaleemnasir.olympic.games.analysis;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        String filePath="./assets/medals.txt";

        var teamResultList = FileParser.parseTeamResults(filePath);

        System.out.println(teamResultList.size());

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(7);

        Future<String> task1Future = executorService.submit(new Task1Callable(teamResultList, 4));
        Future<List<TeamResult>> task3Future = executorService.submit(new Task3Callable(teamResultList));

        Task2Runnable task2Runnable = new Task2Runnable(teamResultList);
        long initialDelay = 3;

        executorService.scheduleWithFixedDelay(task2Runnable, initialDelay, 5L, TimeUnit.SECONDS);



        System.out.println("Task 1");
        System.out.println(task1Future.get());
        System.out.println("Task 3");
        System.out.println(task3Future.get());

        
        

    }
}