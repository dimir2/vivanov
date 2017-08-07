package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class CounterTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 07.08.2017
 */
public class CounterTest {

    /**
     * Test range 0 1 2 3 4 5 6 7 8 9 10 - sum of evens is 30.
     */
    @Test
    public void whenRangeFromZeroToTenThenGotThirty() {
        Counter c = new Counter();
        int result = c.add(0, 10);
        int expected = 30;
        assertThat(result, is(expected));

    }

}