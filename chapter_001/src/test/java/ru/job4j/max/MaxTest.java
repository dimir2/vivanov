package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class MaxTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 07.08.2017
 */
public class MaxTest {
    /**
     * Test max method.
     *
     * @author Vladimir Ivanov
     * @since 07.08.2017
     */
    @Test
    public void whenChooseMaxBetweenOneAndTwoThenGotTwoAsMax() {
        Max maxim = new Max();
        int result = maxim.max(1,2);
        assertThat(result, is(2));
    }
}
