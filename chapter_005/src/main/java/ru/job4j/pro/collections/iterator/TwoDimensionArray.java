package ru.job4j.pro.collections.iterator;

import java.util.Iterator;

/**
 * Class TwoDimensionArray.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 24.08.2017
 */
public class TwoDimensionArray implements Iterable {

    /**
     * 2D Array of ints.
     */
    private final int[][] array;

    /**
     * Construct 2D arrays of ints.
     *
     * @param array 2D array of ints.
     */
    TwoDimensionArray(int[][] array) {
        this.array = array;
    }

    /**
     * Iterator thru 2D array of ints.
     *
     * @return Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new TwoDimensionArrayIterator(this.array);
    }
}
