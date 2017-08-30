package ru.job4j.pro.collections.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * SimpleSet class.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 30.08.2017
 */
public class SimpleSetTest {
    /**
     * Test adding to set.
     */
    @Test
    public void whenAddElementsToSetThenGetItThere() {
        SimpleSet<String> set = new SimpleSet<>(10);
        set.add(new String("one"));
        set.add(new String("one"));
        set.add(new String("one"));
        set.add(new String("two"));

        assertThat(set.size(), is(2));
    }

    /**
     * Iteration test..
     */
    @Test
    public void whenAddElementToSetThenWeCanGetItViaIterator() {
        SimpleSet<String> set = new SimpleSet<>(10);
        set.add(new String("one"));
        set.add(new String("one"));
        set.add(new String("one"));
        set.add(new String("two"));
        set.add(new String("two"));

        Iterator<String> it = set.iterator();
        it.next();

        String result = it.next();
        assertThat(result, is("two"));
    }

}