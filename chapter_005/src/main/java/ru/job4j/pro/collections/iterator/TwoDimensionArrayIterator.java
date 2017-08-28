package ru.job4j.pro.collections.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class TwoDimensionArrayIterator.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 24.08.2017
 */
public class TwoDimensionArrayIterator implements Iterator<Integer> {
    /**
     * 2D Array of ints.
     */
    private final int[][] array;
    /**
     * No elements left flag.
     */
    private boolean hasNext;
    /**
     * First element row.
     */
    private int row;
    /**
     * First element column.
     */
    private int column;

    /**
     * Constructs 2D array of ints iterator.
     *
     * @param array @D array.
     */
    public TwoDimensionArrayIterator(final int[][] array) {
        this.array = array;
        this.init();
    }

    /**
     * Initialize iterator.
     */
    private void init() {
        this.row = 0;
        this.column = 0;
        this.hasNext = false;

        if (this.array != null) {
            this.hasNext = true;
            if (!this.checkCurrent()) {
                this.findNext();
            }
        }
    }

    /**
     * Check is array element exists.
     *
     * @return True, if such element exists.
     */
    private boolean checkCurrent() {
        return this.array.length > this.row && this.array[this.row] != null && this.array[this.row].length > this.column;
    }

    /**
     * Set next element.
     */
    private void findNext() {
        boolean result = false;
        this.column++;
        while (this.row < this.array.length) {
            if (this.checkCurrent()) {
                result = true;
                break;
            } else {
                this.row++;
                this.column = 0;
            }
        }
        this.hasNext = result;
    }

    /**
     * Answer the question, if 2D array has next element.
     *
     * @return True if it has, false otherwise.
     */
    @Override
    public boolean hasNext() {
        return this.hasNext;
    }

    /**
     * Return next element of 2D array.
     *
     * @return Next element.
     * @throws NoSuchElementException
     */
    @Override
    public Integer next() throws NoSuchElementException {
        if (!this.hasNext) {
            throw new NoSuchElementException("2D array has no next element");
        }
        int result = this.array[row][column];
        this.findNext();
        return result;
    }
}
