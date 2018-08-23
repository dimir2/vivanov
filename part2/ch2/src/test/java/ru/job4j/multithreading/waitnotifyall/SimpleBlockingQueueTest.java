package ru.job4j.multithreading.waitnotifyall;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleBlockingQueueTest {
    /**
     * Simple test.
     */
    @Test
    public void whenOfferValueThenCanPollIt() throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(3);

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        queue.poll();
        queue.poll();
        int result = queue.poll();

        assertThat(result, is(3));
    }

    /**
     * Simple test not working.
     */
    @Test
    public void whenOfferValueThenCannotPollIt() throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(3);

        Thread first = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    queue.poll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        first.start();

        first.join();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        queue.poll();
        queue.poll();
        int result = queue.poll();

        assertThat(result, is(4));
    }

}