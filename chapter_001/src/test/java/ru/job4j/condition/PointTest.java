package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class PointTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 07.08.2017
 */
public class PointTest {
    /**
     * Test is method (true condition).
     *
     * @author Vladimir Ivanov
     * @since 07.08.2017
     */
    @Test
    public void whenPointIsOnLineThenTrue() {
        Point point = new Point(2,4);
        boolean result = point.is(1,2);
        assertThat(result, is(true));
    }
    /**
     * Test is method (false condition).
     *
     * @author Vladimir Ivanov
     * @since 07.08.2017
     */
    @Test
    public void whenPointIsNotOnLineThenFalse() {
        Point point = new Point(2,4);
        boolean result = point.is(3,1);
        assertThat(result, is(false));
    }

}