package ru.job4j.pro.collections.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * PrimeIt class.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 25.08.2017
 */
public class PrimeIt implements Iterator<Integer> {
    /**
     * Array of ints.
     */
    private int[] array;
    /**
     * Current position in array. Always points on next prime, or -1, if no prime left.
     */
    private int current;

    /**
     * Construct Even iterator.
     *
     * @param array Array of ints
     * @return
     */
    public PrimeIt(int[] array) {
        this.array = array;
        if (array == null) {
            this.current = -1;
        } else {
            this.current = this.findNearestPrime(0);
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
     * Next prime element implementation.
     *
     * @return Next prime element from array.
     * @throws NoSuchElementException
     */
    @Override
    public Integer next() throws NoSuchElementException {
        if (this.current == -1) {
            throw new NoSuchElementException("No even numbers left in array");
        }
        int result = this.array[this.current];
        this.current = this.findNearestPrime(this.current + 1);
        return result;
    }

    /**
     * Find nearest prime number index in the array, starting with given index.
     *
     * @param index Start index to find next prime.
     * @return Index of nearest prime number, -1 if not found.
     */
    private int findNearestPrime(int index) {
        int result = -1;
        while (this.array.length > index) {
            if (this.array[index] < 2) {
                result = index;
                break;
            } else {
                int divisors = 0;
                for (int number = this.array[index]; number > 0; number--) {
                    if (this.array[index] % number == 0) {
                        divisors++;
                    }
                }
                if (divisors == 2) {
                    result = index;
                    break;
                }
            }
            index++;
        }
        return result;
    }
}
