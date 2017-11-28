package ru.job4j.multithreading.monitor;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * Class CountTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 26.12.2017
 */
public class CountTest {

    @Test
    public void whenExecute2ThreadThen2() throws InterruptedException {
        //Create counter.
        final Count count = new Count();
        //Create threads.
        Thread first = new ThreadCount(count);
        Thread second = new ThreadCount(count);
        //Run threads.
        first.start();
        second.start();
        //Make main thread to wait others.
        first.join();
        second.join();
        //Check results.
        assertThat(count.get(), is(2));

    }

    private class ThreadCount extends Thread {
        private final Count count;

        private ThreadCount(final Count count) {
            this.count = count;
        }

        @Override
        public void run() {
            this.count.increment();
        }
    }
}