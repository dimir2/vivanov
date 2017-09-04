package ru.job4j.pro.collections.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class TreeTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 04.09.2017
 */
public class TreeTest {
    /**
     * Add elements into empty tree.
     */
    @Test
    public void whenAddParentChildPairIntoEmptyTreeThenGetTwoElementsAdded() {
        Tree<Integer> tree = new Tree<>();
        tree.add(5, 8);

        List<Integer> result = new ArrayList<>();
        for (Integer elem : tree) {
            result.add(elem);
        }

        List expected = new ArrayList();
        expected.add(5);
        expected.add(8);

        assertThat(result, is(expected));
    }

    /**
     * Add more elements into tree.
     */
    @Test
    public void whenAddMoreElementsIntoThenGetAllElementsAdded() {
        Tree<Integer> tree = new Tree<>();
        tree.add(5, 8);
        tree.add(8, 13);
        tree.add(5, 9);
        List<Integer> result = new ArrayList<>();
        for (Integer elem : tree) {
            result.add(elem);
        }

        List expected = new ArrayList();
        expected.add(5);
        expected.add(8);
        expected.add(13);
        expected.add(9);

        assertThat(result, is(expected));
    }
}