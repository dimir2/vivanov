package ru.job4j.pro.collections;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * PrimeIt test class.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 25.08.2017
 */
public class PrimeItTest {

    /**
     * Test iterator.next() method should return all primes.
     */
    @Test
    public void whenArrayHasThreePrimesThenGetThisThreePrimes() {
        PrimeIt it = new PrimeIt(new int[]{3, 4, 5, 6, 7});

        int[] result = new int[]{it.next(), it.next(), it.next()};

        assertThat(result, is(new int[]{3, 5, 7}));
    }

    /**
     * Test that hasNext return false when no prime elements left.
     */
    @Test
    public void whenNoPrimeElementsLeftInArrayThenHasNextReturnFalse() {
        PrimeIt it = new PrimeIt(new int[]{3, 4, 5, 6, 7});

        it.next();
        it.next();
        it.next();
        boolean result = it.hasNext();

        assertThat(result, is(false));
    }

    /**
     * Test that hasNext return false when array is empty.
     */
    @Test
    public void whenArrayIsEmptyThenHasNextReturnFalse() {
        PrimeIt it = new PrimeIt(new int[]{});

        boolean result = it.hasNext();

        assertThat(result, is(false));
    }

    /**
     * Test that hasNext return false when array is null.
     */
    @Test
    public void whenArrayIsNullThenHasNextReturnFalse() {
        PrimeIt it = new PrimeIt(null);

        boolean result = it.hasNext();

        assertThat(result, is(false));
    }

    /**
     * Test that next after last prime will cause NoSuchElementException.
     */
    @Test
    public void whenNoPrimeElementsLeftInArrayThenNextCauseNoSuchElementException() {
        PrimeIt it = new PrimeIt(new int[]{3, 4, 5, 6, 7});

        Exception result = null;
        try {
            it.next();
            it.next();
            it.next();
            it.next();
        } catch (Exception e) {
            result = e;
        }

        assertThat(result, instanceOf(NoSuchElementException.class));
    }
}
