package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.LogisticBase;
import org.example.model.Truck;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static String INPUT_FILE;
    public static void main(String[] args) throws InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Truck> trucksList = new ArrayList<>();
        try {
            //todo тут вынести в переменную чтобы не было двух точек в одной строке
            trucksList = Arrays.asList(objectMapper.readValue(INPUT_FILE, Truck[].class));
        } catch (IOException e) {
            System.out.println(e);
        }

        LogisticBase logisticBase = new LogisticBase();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i <trucksList.size(); i++) {
            Thread thread = new Thread(new Truck());
            threads.add(thread);
            thread.start();
        }

        for (Thread thread: threads) {
            thread.join();
        }

//        ExecutorService executorService;
//        executorService.shutdown();

    }
}