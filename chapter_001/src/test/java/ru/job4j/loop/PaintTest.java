package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class PaintTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 08.08.2017
 */
public class PaintTest {

    /**
     * Test piramid with two rows.
     */
    @Test
    public void whenPiramidHeightIsTwoThanStringWithTwoRows() {
        Paint paint = new Paint();
        String result = paint.piramid(2);
        StringBuilder expected = new StringBuilder();
        expected.append(" ^").append(System.getProperty("line.separator"));
        expected.append("^^^").append(System.getProperty("line.separator"));
        assertThat(result, is(expected.toString()));
    }

    /**
     * Test piramid with one row.
     */
    @Test
    public void whenPiramidHeightIsOneThanStringWithOneSymbol() {
        Paint paint = new Paint();
        String result = paint.piramid(1);
        StringBuilder expected = new StringBuilder();
        expected.append("^").append(System.getProperty("line.separator"));
        assertThat(result, is(expected.toString()));
    }
}