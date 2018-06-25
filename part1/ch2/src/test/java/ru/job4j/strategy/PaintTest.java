package ru.job4j.strategy;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Paint Test.
 *
 * @author Vladimir
 * @version 0.1
 * @since 15.08.2017
 */
public class PaintTest {

    /**
     * Draw triangle test.
     */
    @Test
    public void whenDrawTriangleThenItDrawTriangle() {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result));
        new Paint().draw(new Triangle());
        StringBuilder expected = new StringBuilder();
        expected.append("   *").append(System.lineSeparator());
        expected.append("  ***").append(System.lineSeparator());
        expected.append(" *****").append(System.lineSeparator());
        expected.append("*******");
        expected.append(System.lineSeparator());
        assertThat(result.toString(), is(expected.toString()));
    }

    /**
     * Draw triangle test.
     */
    @Test
    public void whenDrawSquareThenItDrawSquare() {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result));
        new Paint().draw(new Square());
        StringBuilder expected = new StringBuilder();
        expected.append("*****").append(System.lineSeparator());
        expected.append("*****").append(System.lineSeparator());
        expected.append("*****").append(System.lineSeparator());
        expected.append("*****").append(System.lineSeparator());
        expected.append("*****").append(System.lineSeparator());
        assertThat(result.toString(), is(expected.toString()));
    }
}