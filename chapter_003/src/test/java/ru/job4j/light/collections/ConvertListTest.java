package ru.job4j.light.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ConvertListTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 21.08.2017
 */
public class ConvertListTest {

    /**
     * Convert 2D-array of ints to List.
     */
    @Test
    public void whenConvert2DArrayToListThenGetList() {
        int[][] array = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> expected = new ArrayList<>();
        for (int index = 1; index <= 9; index++) {
            expected.add(index);
        }
        assertThat(new ConvertList().toList(array), is(expected));
    }

    /**
     * Convert 2D-array with nulls to List.
     */
    @Test
    public void whenConvert2DArrayWithNullToListThenGetList() {
        int[][] array = new int[][]{{1, 2, 3}, {}, null, {4, 5}, {6, 7, 8, 9}};
        List<Integer> expected = new ArrayList<>();
        for (int index = 1; index <= 9; index++) {
            expected.add(index);
        }
        assertThat(new ConvertList().toList(array), is(expected));
    }

    /**
     * Convert List to 2D-array of ints.
     */
    @Test
    public void whenConvertListTo2DArrayThenGet2DArray() {

        List<Integer> list = new ArrayList<>();
        for (int index = 1; index <= 7; index++) {
            list.add(index);
        }
        int[][] expected = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        assertThat(new ConvertList().toArray(list, 3), is(expected));
    }


    /**
     * Convert List with null to 2D-array of ints.
     */
    @Test
    public void whenConvertListWithNullTo2DArrayThenGet2DArray() {

        List<Integer> list = new ArrayList<>();
        for (int index = 1; index <= 7; index++) {
            list.add(index);
        }
        list.add(5, null);
        list.add(1, null);
        int[][] expected = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        assertThat(new ConvertList().toArray(list, 3), is(expected));
    }


    /**
     * Convert List of arrays of ints to List of Integers.
     */
    @Test
    public void whenConvertListOfArraysOfIntsThenGetListOfIntegers() {
        List<int[]> list = new ArrayList<>();
        list.addAll(Arrays.asList(new int[]{1, 2, 3}, new int[]{4, 5, 6, 7}));
        List<Integer> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertThat(new ConvertList().convert(list), is(expected));
    }


    /**
     * Convert List of arrays with null to List of Integers.
     */
    @Test
    public void whenConvertListOfArraysOfIntsWithNullThenGetListOfIntegers() {
        List<int[]> list = new ArrayList<>();
        list.addAll(Arrays.asList(new int[]{1, 2, 3}, null, new int[]{4, 5, 6, 7}, null));
        List<Integer> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertThat(new ConvertList().convert(list), is(expected));
    }
}