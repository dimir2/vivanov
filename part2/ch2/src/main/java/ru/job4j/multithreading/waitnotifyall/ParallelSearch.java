package ru.job4j.multithreading.waitnotifyall;

import java.util.stream.IntStream;

public class ParallelSearch {

    public static void main(String[] args) {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<Integer>();
        final Thread consumer = new Thread(
                () -> {
                    while (true) {
                        try {
                            System.out.println(queue.poll());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                }
        );
        consumer.start();
        new Thread(
                () -> {
                    IntStream.range(0, 30).forEach(index -> {
                        queue.offer(index);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                    consumer.interrupt();
                }
        ).start();
    }
}
