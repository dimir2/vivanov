package ru.job4j.pro.collections.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class BinaryTreeTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 05.09.2017
 */
public class BinaryTreeTest {
    /**
     * Add element into empty tree.
     */
    @Test
    public void whenAddElementIntoEmptyTreeThenGetOneElementAdded() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(5);
        Iterator<Integer> it = tree.iterator();
        int result = it.next();

        assertThat(result, is(5));
    }

    /**
     * Add more elements into tree.
     */
    @Test
    public void whenAddMoreElementsIntoEmptyTreeThenGetAllElementsAdded() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(5);
        tree.add(13);
        tree.add(17);
        tree.add(42);

        Iterator<Integer> it = tree.iterator();
        int[] result = new int[]{it.next(), it.next(), it.next(), it.next()};
        int[] expected = new int[]{5, 13, 17, 42};

        assertThat(result, is(expected));
    }

    /**
     * Added elements are sorted.
     */
    @Test
    public void whenAddElementsIntoTreeThenGetSortedElements() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(5);
        tree.add(2);
        tree.add(7);
        tree.add(2);
        tree.add(42);

        Iterator<Integer> it = tree.iterator();
        int[] result = new int[]{it.next(), it.next(), it.next(), it.next(), it.next()};
        int[] expected = new int[]{2, 2, 5, 7, 42};

        assertThat(result, is(expected));
    }

}