package ru.job4j.pro.collections.list;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * SimpleQueueTest class.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 29.08.2017
 */
public class SimpleQueueTest {
    /**
     * Test polling 3 elements.
     */
    @Test
    public void whenPollThreeElementsThenGetThemAll() {
        SimpleQueue<String> queue = new SimpleQueue<>();
        queue.push(new String("1"));
        queue.push(new String("2"));
        queue.push(new String("3"));

        String result = String.format("%s:%s:%s", queue.poll(), queue.poll(), queue.poll());
        String expected = "1:2:3";

        assertThat(result, is(expected));
    }


    /**
     * Test polling more elements than stack has.
     */
    @Test
    public void whenPollMoreElementsThanStackHasThenGetEmptyQueueException() {
        SimpleQueue<String> queue = new SimpleQueue<>();
        queue.push(new String("1"));
        queue.push(new String("2"));
        queue.push(new String("3"));

        queue.poll();
        queue.poll();
        queue.poll();

        Exception result = null;
        try {
            queue.poll();
        } catch (Exception e) {
            result = e;
        }

        assertThat(result, instanceOf(EmptyQueueException.class));
    }
}