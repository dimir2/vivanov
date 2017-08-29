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
        if (array != null) {
            while (this.array.length > this.current) {
                if (this.isPrime(this.array[this.current])) {
                    result = true;
                    break;
                }
                this.current++;
            }
        }
        return result;
    }

    /**
     * Next prime element implementation.
     *
     * @return Next prime element from array.
     * @throws NoSuchElementException
     */
    @Override
    public Integer next() throws NoSuchElementException {
        if (!this.hasNext()) {
            throw new NoSuchElementException("No even numbers left in array");
        }
        return this.array[this.current++];
    }

    /**
     * Tests if the given number is prime.
     *
     * @param value Value to test.
     * @return True if it is prime, false otherwise.
     */
    private boolean isPrime(int value) {
        boolean result = false;
        if (value < 2) {
            result = true;
        } else {
            int divisors = 0;
            for (int number = value; number > 0; number--) {
                if (value % number == 0) {
                    divisors++;
                }
            }
            if (divisors == 2) {
                result = true;

            }
        }
        return result;
    }
}
