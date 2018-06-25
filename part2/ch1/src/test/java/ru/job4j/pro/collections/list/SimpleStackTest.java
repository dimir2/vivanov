package ru.job4j.pro.collections.list;

import org.junit.Test;

import java.util.EmptyStackException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * SimpleStackTest class.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 29.08.2017
 */
public class SimpleStackTest {
    /**
     * Test polling 3 elements.
     */
    @Test
    public void whenPollThreeElementsThenGetThemAll() {
        SimpleStack<String> stack = new SimpleStack<>();
        stack.push(new String("1"));
        stack.push(new String("2"));
        stack.push(new String("3"));

        String result = String.format("%s:%s:%s", stack.poll(), stack.poll(), stack.poll());
        String expected = "3:2:1";

        assertThat(result, is(expected));
    }

    /**
     * Test polling more elements than stack has.
     */
    @Test
    public void whenPollMoreElementsThanStackHasThenGetEmptyStackException() {
        SimpleStack<String> stack = new SimpleStack<>();
        stack.push(new String("1"));
        stack.push(new String("2"));
        stack.push(new String("3"));

        stack.poll();
        stack.poll();
        stack.poll();

        Exception result = null;
        try {
            stack.poll();
        } catch (Exception e) {
            result = e;
        }

        assertThat(result, instanceOf(EmptyStackException.class));
    }
}