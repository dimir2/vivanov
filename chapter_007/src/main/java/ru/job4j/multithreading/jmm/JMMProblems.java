package ru.job4j.multithreading.jmm;

import java.util.ArrayList;
import java.util.List;

/**
 * Class JMMProblems.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 27.11.2017
 */
public class JMMProblems {
    public volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {
        JMMProblems jmm = new JMMProblems();
        System.out.println("Count = " + jmm.count);
        Runnable doer = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500; i++) {
                    jmm.count++;
                }
            }
        };
        List<Thread> pool = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            pool.add(new Thread(doer));
        }

        for (Thread thread : pool) {
            thread.start();
        }

        for (Thread thread : pool) {
            thread.join();
        }
        System.out.println("Count = " + jmm.count);
    }
}
