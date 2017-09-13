package ru.job4j.pro.collections.generic.orderbook.tdd;

import org.junit.Test;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Class OrderTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 13.09.2017
 */
public class OrderTest {
    @Test
    public void whenCreateOrderThenItsIsCreated() {
        Order order = new Order("book", 10);
        assertThat(order, instanceOf(Order.class));
    }

    @Test
    public void whenCreateOrderWithParametersThenItIsCreated() {
        Order order = new Order("book-1", "SELL", 100.50f, 81, 1);
        assertThat(order, instanceOf(Order.class));
    }

    @Test
    public void whenCreateOrderWithParametersThenTheyCanBeAccessed() {
        Order order = new Order("book-1", "SELL", 100.50f, 81, 1);
        assertThat(order.book, is("book-1"));
        assertThat(order.op, is("SELL"));
        assertThat(order.price, is(100.50f));
        assertThat(order.value, is(81));
        assertThat(order.id, is(1));
    }

    @Test
    public void whenCreateDeleteOrderWithBookAndIdParametersThenOthersAreNullOrZero() {
        Order order = new Order("book-1", 12);
        assertThat(order.book, is("book-1"));
        assertNull(order.op);
        assertThat(order.price, is(0.0f));
        assertThat(order.value, is(0));
        assertThat(order.id, is(12));
    }

    @Test
    public void whenCreateOrderThenItIsComparable() {
        Order order = new Order("book", 10);
        assertThat(order, instanceOf(Comparable.class));
    }

    @Test
    public void whenCompareOrdersWithSameIdsThenTheResultIsZero() {
        Order order = new Order("book", "BUY", 99.0f, 10, 1);
        Order delOrder = new Order("book", 1);
        assertThat(order.compareTo(delOrder), is(0));
    }

    @Test
    public void whenFirstIdLessThanSecondThenTheResultIsLessThanZero() {
        Order order = new Order("book", "BUY", 99.0f, 10, 1);
        Order delOrder = new Order("book", 2);
        assertTrue(order.compareTo(delOrder) < 0);
    }

    @Test
    public void whenFirstIdGreaterThanSecondThenTheResultIsGreaterThanZero() {
        Order order = new Order("book", "BUY", 99.0f, 10, 10);
        Order delOrder = new Order("book", 2);
        assertTrue(order.compareTo(delOrder) > 0);
    }

    @Test
    public void whenOrdersIdsAreDifferentThenOrdersAreNotEqual() {
        Order order = new Order("book", "BUY", 99.0f, 10, 10);
        Order delOrder = new Order("book", 2);
        assertFalse(order.equals(delOrder));
    }

    @Test
    public void whenOrdersIdsAreTheSameThenOrdersAreEqual() {
        Order order = new Order("book", "BUY", 99.0f, 10, 2);
        Order delOrder = new Order("book", 2);
        assertTrue(order.equals(delOrder));
    }


    @Test
    public void whenOrdersIdsAreDifferentThenOrdersHashCodesAreDifferent() {
        Order order = new Order("book", "BUY", 99.0f, 10, 10);
        Order delOrder = new Order("book", 2);
        assertFalse(order.hashCode() == delOrder.hashCode());
    }

    @Test
    public void whenOrdersIdsAreTheSameThenOrdersHashCodesAreTheSame() {
        Order order = new Order("book", "BUY", 99.0f, 10, 2);
        Order delOrder = new Order("book", 2);
        assertTrue(order.hashCode() == delOrder.hashCode());
    }
}
