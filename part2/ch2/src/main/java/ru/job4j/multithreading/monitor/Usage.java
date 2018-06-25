package ru.job4j.multithreading.monitor;

import net.jcip.annotations.ThreadSafe;

/**
 * Class Usage.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 28.11.2017
 */
public class Usage {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread threadA = new CounterThread(counter);
        Thread threadB = new CounterThread(counter);

        threadA.run();
        threadB.run();
        //threadA.join();
        //threadB.join();

        System.out.println(counter.count);
    }

    @ThreadSafe
    public final static class Counter {
        long count = 0;

        public void add(long value) {
            this.count += value;
        }
    }

    public static final class CounterThread extends Thread {
        protected final Counter counter;

        public CounterThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.add(1);
        }
    }
}
