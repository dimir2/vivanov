package ru.job4j.pro.collections.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * NodeListTest class.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 30.08.2017
 */
public class NodeListTest {
    /**
     * Test list is not cycled.
     */
    @Test
    public void whenListIsNotCycledThenGetFalse() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = five;

        NodeList<Integer> list = new NodeList<>(first);
        boolean result = list.hasCycle();

        assertThat(result, is(false));
    }

    /**
     * Test list is cycled.
     */
    @Test
    public void whenListIsCycledThenGetTrue() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;

        NodeList<Integer> list = new NodeList<>(first);
        boolean result = list.hasCycle();

        assertThat(result, is(true));
    }

    /**
     * Test list is cycled.
     */
    @Test
    public void whenBigListIsCycledThenGetTrue() {
        Node<Integer> node = new Node<>(0);
        Node<Integer> cycleFrom = null;
        Node<Integer> cycleTo = null;
        NodeList<Integer> list = new NodeList<>(node);
        for (int value = 1; value < 10000000; value++) {
            node.next = new Node<>(value);
            node = node.next;
            if (value == 900000) {
                cycleTo = node;
            } else if (value == 9990000) {
                cycleFrom = node;
            }
        }
        cycleFrom.next = cycleTo;

        boolean result = list.hasCycle();
        assertThat(result, is(true));
    }

}