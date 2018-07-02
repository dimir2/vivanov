package ru.job4j.multithreading.waitnotifyall;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleBlockingQueueTest {
    /**
     * Simple test.
     */
    @Test
    public void whenOfferValueThenCanPollIt() {
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
    public void whenOfferValueThenCannotPollIt() {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(3);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.poll();
            }
        }

        ).start();
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