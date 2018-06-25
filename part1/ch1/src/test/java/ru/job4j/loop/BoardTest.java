package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class BoardTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 07.08.2017
 */
public class BoardTest {

    /**
     * Board 3x3 paint test.
     */
    @Test
    public void whenBoardThreeByThreeThenPaintIt() {
        Board board = new Board();
        String result = board.paint(3, 3);
        String odd = "x x" + System.getProperty("line.separator");
        String even = " x " + System.getProperty("line.separator");
        StringBuilder expected = new StringBuilder();
        expected.append(odd).append(even).append(odd);
        assertThat(result, is(expected.toString()));
    }

    /**
     * Board 8x8 paint test.
     */
    @Test
    public void whenBoardEightByEightThenPaintIt() {
        Board board = new Board();
        String result = board.paint(8, 8);
        String odd = "x x x x " + System.getProperty("line.separator");
        String even = " x x x x" + System.getProperty("line.separator");
        StringBuilder expected = new StringBuilder();
        expected.append(odd).append(even).append(odd).append(even);
        expected.append(odd).append(even).append(odd).append(even);
        assertThat(result, is(expected.toString()));
    }
}