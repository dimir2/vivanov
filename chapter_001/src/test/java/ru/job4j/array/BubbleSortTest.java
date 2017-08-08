package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class BubbleSortTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 08.08.2017
 */
public class BubbleSortTest {

    /**
     * test sort of already sorted array {1,2,3,4,5,6,7}.
     */
    @Test
    public void whenSortedArrayThenNoChange() {
        BubbleSort bs = new BubbleSort();
        int[] result = bs.sort(new int[]{1, 2, 3, 4, 5, 6, 7});
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7};
        assertThat(result, is(expected));
    }

    /**
     * test sort of array {7,1,2,4,6,3,5}.
     */
    @Test
    public void whenSortArrayThenItSorted() {
        BubbleSort bs = new BubbleSort();
        int[] result = bs.sort(new int[]{7, 1, 2, 4, 6, 3, 5});
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7};
        assertThat(result, is(expected));
    }

    /**
     * test sort of reverse sorted array {7,6,5,4,3,2,1}.
     */
    @Test
    public void whenReverseSortedArrayThenItSorted() {
        BubbleSort bs = new BubbleSort();
        int[] result = bs.sort(new int[]{7, 6, 5, 4, 3, 2, 1});
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7};
        assertThat(result, is(expected));
    }

}