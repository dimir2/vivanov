package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class FactorialTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 07.08.2017
 */
public class FactorialTest {

    /**
     * 5!=120 Factorial Test.
     */
    @Test
    public void whenNumberIsFiveThenFactorialIsOneHundredAndTwenty() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(5);
        int expected = 120;
        assertThat(result, is(expected));
    }
    /**
     * 0!=1 Factorial Test.
     */
    @Test
    public void whenNumberIsZeroThenFactorialIsOne() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(0);
        int expected = 1;
        assertThat(result, is(expected));
    }
}