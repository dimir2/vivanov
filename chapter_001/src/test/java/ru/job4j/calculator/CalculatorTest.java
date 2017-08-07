package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class CalculatorTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 07.08.2017
 */
public class CalculatorTest {

    /**
     * Test add method.
     *
     * @author Vladimir Ivanov
     * @since 07.08.2017
     */
    @Test
    public void whenAddOneAndTwoThenGotThreeAsResult() {
        Calculator calc = new Calculator();
        calc.add(1d, 2d);
        assertThat(calc.getResult(), is(3d));
    }

    /**
     * Test subtract method.
     *
     * @author Vladimir Ivanov
     * @since 07.08.2017
     */
    @Test
    public void whenSubtracOneFromTwoThenGotOneAsResult() {
        Calculator calc = new Calculator();
        calc.subtract(2d, 1d);
        assertThat(calc.getResult(), is(1d));
    }

    /**
     * Test divide method.
     *
     * @author Vladimir Ivanov
     * @since 07.08.2017
     */
    @Test
    public void whenDivideThreeByTwoThenGotOneAndHalfAsResult() {
        Calculator calc = new Calculator();
        calc.divide(3d, 2d);
        assertThat(calc.getResult(), is(1.5d));
    }

    /**
     * Test multiply method.
     *
     * @author Vladimir Ivanov
     * @since 07.08.2017
     */
    @Test
    public void whenMultiplyThreeByTwoThenGotSixAsResult() {
        Calculator calc = new Calculator();
        calc.multiply(3d, 2d);
        assertThat(calc.getResult(), is(6d));
    }
}
