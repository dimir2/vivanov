package ru.job4j.array;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class RotateArrayTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 08.08.2017
 */
public class RotateArrayTest {

    private static int[][] copy(int[][] array) {
        return Arrays.stream(array).map(el -> el.clone()).toArray(int[][]::new);
    }

    /**
     * Test rotate 2x2 array.
     */
    @Test
    public void whenRotateTwoByTwoArrayThenRotatedArray() {
        RotateArray ra = new RotateArray();
        int[][] array = {{1, 2}, {3, 4}};
        int[][] expected = {{3, 1}, {4, 2}};
        assertThat("Original rotate", ra.rotate(copy(array)), is(expected));
        assertThat("Simplified rotate", ra.rotateSimple(copy(array)), is(expected));
        assertThat("Copy rotate", ra.rotateCopy(array), is(expected));
    }

    /**
     * Test rotate 3x3 array.
     */
    @Test
    public void whenRotateThreeByThreeArrayThenRotatedArray() {
        RotateArray ra = new RotateArray();
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        assertThat("Original rotate", ra.rotate(copy(array)), is(expected));
        assertThat("Simplified rotate", ra.rotateSimple(copy(array)), is(expected));
        assertThat("Copy rotate", ra.rotateCopy(array), is(expected));
    }


    /**
     * Test rotate 4x4 array.
     */
    @Test
    public void whenRotateFourByFourArrayThenRotatedArray() {
        RotateArray ra = new RotateArray();
        int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] expected = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
        assertThat("Original rotate", ra.rotate(copy(array)), is(expected));
        assertThat("Simplified rotate", ra.rotateSimple(copy(array)), is(expected));
        assertThat("Copy rotate", ra.rotateCopy(array), is(expected));
    }
}