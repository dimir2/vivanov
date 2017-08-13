package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class MergeArrays Test.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 13.08.2017
 */
public class MergeArraysTest {

    /**
     * Merge two sorted arrays of int test.
     */
    @Test
    public void whenMergeTwoSortedArraysThenGotOneSortedArray() {
        int[] left = new int[]{1, 7, 8, 9};
        int[] right = new int[]{-1, 0, 3, 5, 6};
        int[] expected = new int[]{-1, 0, 1, 3, 5, 6, 7, 8, 9};
        MergeArrays ma = new MergeArrays();
        int[] result = ma.merge(left, right);
        assertThat(result, is(expected));
    }

}