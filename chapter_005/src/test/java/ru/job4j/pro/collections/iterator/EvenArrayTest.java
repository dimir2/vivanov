package ru.job4j.pro.collections.iterator;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class EvenArrayTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 25.08.2017
 */
public class EvenArrayTest {
    /**
     * Test even array has two even numbers at the beginning.
     */
    @Test
    public void whenArrayHasTwoEvenNumbersThenGetTwoNumbersByNext() {
        EvenArray array = new EvenArray(new int[]{2, 4, 1, 1});
        Iterator<Integer> it = array.iterator();

        int[] result = new int[]{it.next(), it.next()};

        assertThat(result, is(new int[]{2, 4}));
    }

    /**
     * Test even array has two even numbers in the middle.
     */
    @Test
    public void whenArrayHasTwoEvenNumbersInTheMiddleThenGetTwoNumbersByNext() {
        EvenArray array = new EvenArray(new int[]{1, 3, 2, 4, 1, 1});
        Iterator<Integer> it = array.iterator();

        int[] result = new int[]{it.next(), it.next()};

        assertThat(result, is(new int[]{2, 4}));
    }

    /**
     * Test hasNext should return false when no more even elements.
     */
    @Test
    public void whenArrayHasNoEvenNumbersLeftThenGetFalseFromHasNext() {
        EvenArray array = new EvenArray(new int[]{1, 3, 2, 4, 1, 1});
        Iterator<Integer> it = array.iterator();

        it.next();
        it.next();
        boolean result = it.hasNext();

        assertThat(result, is(false));
    }

    /**
     * Test next() should raise the NoSuchElementException when no more even elements.
     */
    @Test
    public void whenArrayHasNoEvenNumbersLeftThenGetNoSuchElementException() {
        EvenArray array = new EvenArray(new int[]{1, 3, 2, 4, 1, 1});
        Iterator<Integer> it = array.iterator();

        Exception result = null;
        try {
            it.next();
            it.next();
            it.next();
        } catch (Exception e) {
            result = e;
        }

        assertThat(result, instanceOf(NoSuchElementException.class));
    }

    /**
     * Test next() should raise the NoSuchElementException when array is empty.
     */
    @Test
    public void whenArrayIsEmptyThenGetNoSuchElementException() {
        EvenArray array = new EvenArray(new int[]{});
        Iterator<Integer> it = array.iterator();

        Exception result = null;
        try {
            it.next();
        } catch (Exception e) {
            result = e;
        }

        assertThat(result, instanceOf(NoSuchElementException.class));
    }

    /**
     * Test next() should raise the NoSuchElementException when array is null.
     */
    @Test
    public void whenArrayIsNullThenGetNoSuchElementException() {
        EvenArray array = new EvenArray(new int[]{});
        Iterator<Integer> it = array.iterator();

        Exception result = null;
        try {
            it.next();
        } catch (Exception e) {
            result = e;
        }

        assertThat(result, instanceOf(NoSuchElementException.class));
    }
}