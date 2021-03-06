package ru.job4j.pro.collections.set;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * SimpleArraySet class.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 30.08.2017
 */
public class SimpleSortedSetTest {
    /**
     * Test adding to set.
     */
    @Test
    public void whenAddElementsToSetThenGetItThere() {
        SimpleSet<String> set = new SimpleSortedSet<>();
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
        SimpleSet<String> set = new SimpleSortedSet<>();
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

    /**
     * Test that next after last element will cause NoSuchElementException.
     */
    @Test
    public void whenNoElementsLeftInArraySetThenNextCauseNoSuchElementException() {
        SimpleSet<String> set = new SimpleSortedSet<>();
        set.add(new String("one"));
        set.add(new String("one"));
        set.add(new String("one"));
        set.add(new String("two"));
        set.add(new String("two"));

        Iterator<String> it = set.iterator();
        it.next();

        Exception result = null;
        try {
            it.next();
            it.next();
        } catch (Exception e) {
            result = e;
        }

        assertThat(result, instanceOf(NoSuchElementException.class));
    }

    /**
     * Test that elements are added in sorted order.
     */
    @Test
    public void whenAddElementsThenTheyAddedInSortedOrder() {
        SimpleSet<String> set = new SimpleSortedSet<>();
        set.add(new String("one"));
        set.add(new String("twenty"));
        set.add(new String("eight"));
        set.add(new String("four"));
        set.add(new String("nine"));

        String result = "";
        for (String str : set) {
            result = result + str + ":";
        }

        String expected = "eight:four:nine:one:twenty:";
        assertThat(result, is(expected));
    }
}