package ru.job4j.pro.collections.iterator;

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
        this.current = 0;
    }

    /**
     * hasNext implementation.
     *
     * @return True if next int exists in array.
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        if (this.array != null) {
            while (this.array.length > this.current) {
                if (this.array[this.current] % 2 == 0) {
                    result = true;
                    break;
                }
                this.current++;
            }
        }
        return result;
    }

    /**
     * Next element implementation.
     *
     * @return Next even element from array.
     * @throws NoSuchElementException
     */
    @Override
    public Integer next() throws NoSuchElementException {
        if (!this.hasNext()) {
            throw new NoSuchElementException("No even numbers left in array");
        }
        return this.array[this.current++];
    }
}
