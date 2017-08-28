package ru.job4j.pro.collections.iterator;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class TwoDimensionArrayTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 24.08.2017
 */
public class TwoDimensionArrayTest {
    /**
     * Test hasNext on 2x2 array of ints at the beginning of array.
     */
    @Test
    public void whenRunHasNextAtBeginningThenGetTrue() {
        TwoDimensionArray array = new TwoDimensionArray(new int[][]{{1, 2}, {3, 4}});
        Iterator<Integer> it = array.iterator();

        boolean result = it.hasNext();

        assertThat(result, is(true));
    }

    /**
     * Test hasNext on 2x2 array of ints in the middle of array.
     */
    @Test
    public void whenRunHasNextInTheMiddleThenGetTrue() {
        TwoDimensionArray array = new TwoDimensionArray(new int[][]{{1, 2}, {3, 4}});
        Iterator<Integer> it = array.iterator();

        it.next();
        it.next();
        boolean result = it.hasNext();

        assertThat(result, is(true));
    }

    /**
     * Test hasNext on 2x2 array of ints at the end of array.
     */
    @Test
    public void whenRunHasNextAtTheEndThenGetTrue() {
        TwoDimensionArray array = new TwoDimensionArray(new int[][]{{1, 2}, {3, 4}});
        Iterator<Integer> it = array.iterator();

        it.next();
        it.next();
        it.next();
        boolean result = it.hasNext();

        assertThat(result, is(true));
    }

    /**
     * Test hasNext on 2x2 array of ints after last element.
     */
    @Test
    public void whenRunHasNextAfterLastElementThenGetFalse() {
        TwoDimensionArray array = new TwoDimensionArray(new int[][]{{1, 2}, {3, 4}});
        Iterator<Integer> it = array.iterator();

        it.next();
        it.next();
        it.next();
        it.next();
        boolean result = it.hasNext();

        assertThat(result, is(false));
    }

    /**
     * Test 2x2 array of ints iteration.
     */
    @Test
    public void whenIterateAllTwoByTwoArrayThenGetAllElements() {
        TwoDimensionArray array = new TwoDimensionArray(new int[][]{{1, 2}, {3, 4}});
        Iterator<Integer> it = array.iterator();

        int[] result = new int[]{it.next(), it.next(), it.next(), it.next()};
        int[] expected = new int[]{1, 2, 3, 4};

        assertThat(result, is(expected));
    }

    /**
     * Test iteration 2D array of ints with different amount of elements in the rows.
     */
    @Test
    public void whenIterateArrayWithDifferentRowsThenGetAllElements() {
        TwoDimensionArray array = new TwoDimensionArray(new int[][]{{1}, {2, 3, 4}, null, {5}, {}});
        Iterator<Integer> it = array.iterator();

        int[] result = new int[]{it.next(), it.next(), it.next(), it.next(), it.next()};
        int[] expected = new int[]{1, 2, 3, 4, 5};

        assertThat(result, is(expected));
    }

    /**
     * Test 2D array of ints with empty first row.
     */
    @Test
    public void whenIterateArrayWithEmptyFirstRowThenGetAllElements() {
        TwoDimensionArray array = new TwoDimensionArray(new int[][]{{}, {1, 2}, {3, 4}});
        Iterator<Integer> it = array.iterator();

        int[] result = new int[]{it.next(), it.next(), it.next(), it.next()};
        int[] expected = new int[]{1, 2, 3, 4};

        assertThat(result, is(expected));
    }

    /**
     * Test 2D array of ints with empty row in the middle.
     */
    @Test
    public void whenIterateArrayWithEmptyRowInTheMiddleThenGetAllElements() {
        TwoDimensionArray array = new TwoDimensionArray(new int[][]{{1, 2}, {}, {3, 4}});
        Iterator<Integer> it = array.iterator();

        int[] result = new int[]{it.next(), it.next(), it.next(), it.next()};
        int[] expected = new int[]{1, 2, 3, 4};

        assertThat(result, is(expected));
    }

    /**
     * Test 2D array of ints with empty last row.
     */
    @Test
    public void whenIterateArrayWithEmptyLastRowThenGetAllElements() {
        TwoDimensionArray array = new TwoDimensionArray(new int[][]{{1, 2}, {3, 4}, {}});
        Iterator<Integer> it = array.iterator();

        int[] result = new int[]{it.next(), it.next(), it.next(), it.next()};
        int[] expected = new int[]{1, 2, 3, 4};

        assertThat(result, is(expected));
    }

    /**
     * Test 2D array of ints with many empty rows.
     */
    @Test
    public void whenIterateArrayWithManyEmptyRowsThenGetAllElements() {
        TwoDimensionArray array = new TwoDimensionArray(new int[][]{{}, {}, {}, {1, 2}, {}, {}, {}, {3, 4}, {}, {}, {}});
        Iterator<Integer> it = array.iterator();

        int[] result = new int[]{it.next(), it.next(), it.next(), it.next()};
        int[] expected = new int[]{1, 2, 3, 4};

        assertThat(result, is(expected));
    }

    /**
     * Test 2D array of ints with many null rows.
     */
    @Test
    public void whenIterateArrayWithManyNullRowsThenGetAllElements() {
        TwoDimensionArray array = new TwoDimensionArray(new int[][]{null, null, {1, 2}, null, {3, 4}, null, null});
        Iterator<Integer> it = array.iterator();

        int[] result = new int[]{it.next(), it.next(), it.next(), it.next()};
        int[] expected = new int[]{1, 2, 3, 4};

        assertThat(result, is(expected));
    }

    /**
     * Test iteration over last element.
     */
    @Test
    public void whenIterateOverTheLastElementThenGetNoSuchElementException() {
        TwoDimensionArray array = new TwoDimensionArray(new int[][]{{1, 2}});
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
     * Test iteration over empty array.
     */
    @Test
    public void whenIterateOverEmptyArrayThenGetNoSuchElementException() {
        TwoDimensionArray array = new TwoDimensionArray(new int[][]{});
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