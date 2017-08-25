package ru.job4j.pro.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * EvenIt class.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 25.08.2017
 */
public class EvenIt implements Iterator<Integer> {
    /**
     * Array of ints.
     */
    private final int[] array;
    /**
     * Current position.
     */
    private int current;

    /**
     * Construct Even iterator.
     *
     * @param array Array of ints
     * @return
     */
    public EvenIt(int[] array) {
        this.array = array;
        if (array == null) {
            this.current = -1;
        } else {
            this.current = this.findNearestEven(0);
        }
    }

    /**
     * hasNext implementation.
     *
     * @return True if next int exists in array.
     */
    @Override
    public boolean hasNext() {
        return this.current != -1;
    }

    /**
     * Next element implementation.
     *
     * @return Next even element from array.
     * @throws NoSuchElementException
     */
    @Override
    public Integer next() throws NoSuchElementException {
        if (this.current == -1) {
            throw new NoSuchElementException("No even numbers left in array");
        }
        int result = this.array[this.current];
        this.current = this.findNearestEven(this.current + 1);
        return result;
    }

    /**
     * Find nearest even number index in the array, starting with current.
     *
     * @param index Start index to find next even.
     * @return Index of nearest even number, -1 if not found.
     */
    private int findNearestEven(int index) {
        int result = -1;
        while (this.array.length > index) {
            if (this.array[index] % 2 == 0) {
                result = index;
                break;
            }
            index++;
        }
        return result;
    }
}
