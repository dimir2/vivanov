package ru.job4j.pro.collections.list;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ListContainerTest.
 *
 * @author Vladimir
 * @version 0.1
 * @since 29.08.2017
 */
public class ListContainerTest {
    /**
     * Test add elements.
     */
    @Test
    public void whenAddIntegersToListContainerThenCanGetThemBack() {
        SimpleContainer<Integer> list = new ListContainer<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int result = list.get(2);

        assertThat(result, is(3));
    }

    /**
     * Test add String to container and get it.
     */
    @Test
    public void whenAddStringToListContainerThenGetItIn() {
        SimpleContainer<String> list = new ListContainer<>();
        list.add(new String("one"));
        list.add(new String("two"));
        list.add(new String("three"));

        String result = list.get(2);
        assertThat(result, is("three"));
    }


    /**
     * Test that ListContainer is iterable with foreach.
     */
    @Test
    public void whenGetIteratorThenCanForEachContainer() {
        SimpleContainer<String> list = new ListContainer<>();
        list.add(new String("one"));
        list.add(new String("two"));
        list.add(new String("three"));

        String result = "";
        for (String str : list) {
            result = result + str + ":";
        }
        assertThat(result, is("one:two:three:"));
    }

    /**
     * Test that next after last element will cause NoSuchElementException.
     */
    @Test
    public void whenNoElementsLeftInListContainerThenNextCauseNoSuchElementException() {
        SimpleContainer<Integer> arr = new ListContainer<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        Iterator<Integer> it = arr.iterator();

        Exception result = null;
        try {
            it.next();
            it.next();
            it.next();
            it.next();
        } catch (Exception e) {
            result = e;
        }

        assertThat(result, instanceOf(NoSuchElementException.class));
    }

    /**
     * Test that get with wrong index cause ArrayIndexOutOfBoundsException.
     */
    @Test
    public void whenTryToGetNotExistingElementThenGetArrayIndexOutOfBoundsException() {
        SimpleContainer<Integer> arr = new ListContainer<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);

        Exception result = null;
        try {
            arr.get(5);
        } catch (Exception e) {
            result = e;
        }

        assertThat(result, instanceOf(ArrayIndexOutOfBoundsException.class));
    }

    /**
     * Test container size return real size.
     */
    @Test
    public void whenAddTenElementsThenSizeIsTen() {
        SimpleContainer<String> arr = new ListContainer<>();
        arr.add(new String("one"));
        arr.add(new String("two"));
        arr.add(new String("three"));
        arr.add(new String("four"));
        arr.add(new String("five"));
        arr.add(new String("six"));
        arr.add(new String("seven"));
        arr.add(new String("eight"));
        arr.add(new String("nine"));
        arr.add(new String("ten"));

        assertThat(arr.size(), is(10));
    }
}