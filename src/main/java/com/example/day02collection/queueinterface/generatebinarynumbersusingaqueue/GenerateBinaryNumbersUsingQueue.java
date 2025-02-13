package com.example.day02collection.queueinterface.generatebinarynumbersusingaqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateBinaryNumbersUsingQueue {
    public static <T extends Queue<String>> List<String> generateBinaryNumbers(int N, T queue) {
        List<String> result = new ArrayList<>();
        queue.offer("1");

        for (int i = 0; i < N; i++) {
            String binary = queue.poll();
            result.add(binary);

            queue.offer(binary + "0");
            queue.offer(binary + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        int N = 5;

        List<String> result = generateBinaryNumbers(N, new LinkedList<>());
        System.out.println(result);
    }
}

