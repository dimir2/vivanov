package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class TurnTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 08.08.2017
 */
public class TurnTest {

    /**
     * test turn back array {1}.
     */
    @Test
    public void whenTurnBackOneThenGotOne() {
        Turn turn = new Turn();
        int[] result = turn.back(new int[]{1});
        int[] expected = new int[]{1};
        assertThat(result, is(expected));
    }

    /**
     * test turn back array {1,2,3}.
     */
    @Test
    public void whenTurnBackOneTwoThreeArrayThenGotThreeTwoOne() {
        Turn turn = new Turn();
        int[] result = turn.back(new int[]{1, 2, 3});
        int[] expected = new int[]{3, 2, 1};
        assertThat(result, is(expected));
    }

    /**
     * test turn back array {5,5,5,1,4,4,4}.
     */
    @Test
    public void whenTurnBackArrayThenGotItTirned() {
        Turn turn = new Turn();
        int[] result = turn.back(new int[]{5, 5, 5, 1, 4, 4, 4});
        int[] expected = new int[]{4, 4, 4, 1, 5, 5, 5};
        assertThat(result, is(expected));
    }
}