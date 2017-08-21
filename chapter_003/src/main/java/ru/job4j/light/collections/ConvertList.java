package ru.job4j.light.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Class ConvertList.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 21.08.2017
 */
public class ConvertList {

    /**
     * Convert two-dimensional array of ints to flat List of Integers.
     *
     * @param array two-dimensional array of ints.
     * @return Flat List.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : array) {
            for (int value : row) {
                list.add(value);
            }
        }
        return list;
    }

    /**
     * Convert flat List of Integers to two-dimensional array of ints.
     *
     * @param list List of Integers.
     * @param rows Number of rows in resulting array of ints.
     * @return Resulting two-dimensional array of ints.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int listSize = list.size();
        int columns = (int) Math.ceil((double) listSize / rows);
        int[][] result = new int[rows][columns];
        int index = 0;
        while (index < listSize) {
            result[index / columns][index % columns] = list.get(index);
            index++;
        }
        while (index < rows * columns) {
            result[index / columns][index % columns] = 0;
            index++;
        }
        return result;
    }

    /**
     * Convert List containing arrays of ints to List with Integers.
     *
     * @param list List with arrays of ints
     * @return List of Integers.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] array : list) {
            for (int value : array) {
                result.add(value);
            }
        }
        return result;
    }
}
