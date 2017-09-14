package ru.job4j.pro.collections.orderbook.tdd;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class BookTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 13.09.2017
 */
public class BookTest {
    @Test
    public void whenCreateBookThenItIsCreated() {
        Book book = new Book("book");
        assertThat(book, instanceOf(Book.class));
    }

    @Test
    public void whenCreateBookThenItHasName() {
        Book book = new Book("name");
        assertThat(book.name, is("name"));
    }

    @Test
    public void whenAddOrderThenItIsAdded() {
        Book book = new Book("book");
        Order order = new Order("book", "SELL", 19.99f, 100, 1);
        book.add(order);
        List<MatchOrder> result = book.asAskList();

        List<MatchOrder> expected = new ArrayList<>(Arrays.asList(new MatchOrder(19.99f, 100)));
        assertThat(result, is(expected));
    }

    @Test
    public void whenAddBidOrderThenValueIsNegative () {
        Book book = new Book("book");
        book.add(new Order("book", "BUY", 19.99f, 100, 1));
        assertThat(book.asAskList().get(0).value(), is(-100));
    }

    @Test
    public void whenAddAskOrderThenValueIsPositive () {
        Book book = new Book("book");
        book.add(new Order("book", "SELL", 19.99f, 100, 1));
        assertThat(book.asAskList().get(0).value(), is(100));
    }

    @Test
    public void whenAddTwoOrdersSamePriceSameOperationThenValuesSumUp() {
        Book book = new Book("book");
        book.add(new Order("book", "SELL", 19.99f, 100, 1));
        book.add(new Order("book", "SELL", 19.99f, 20, 2));
        List<MatchOrder> result = book.asAskList();

        List<MatchOrder> expected = new ArrayList<>(Arrays.asList(
                new MatchOrder(19.99f, 120)));

        assertThat(result, is(expected));
        assertThat(result.get(0).value(), is(120));
    }

    @Test
    public void whenBidOrderMatchesExistingAskOrderThenGetOneOrder() {
        Book book = new Book("book");
        book.add(new Order("book", "SELL", 19.99f, 100, 1));
        book.add(new Order("book", "BUY", 19.99f, 20, 2));
        List<MatchOrder> result = book.asAskList();

        List<MatchOrder> expected = new ArrayList<>(Arrays.asList(
                new MatchOrder(19.99f, 80)));

        assertThat(result, is(expected));
        assertThat(result.get(0).value(), is(80));
    }

    @Test
    public void whenBidOrderDoesNotMatchExistingAskOrderThenGetTwoOrders() {
        Book book = new Book("book");
        book.add(new Order("book", "SELL", 29.99f, 100, 1));
        book.add(new Order("book", "BUY", 19.99f, 20, 2));
        List<MatchOrder> result = book.asAskList();

        List<MatchOrder> expected = new ArrayList<>(Arrays.asList(
                new MatchOrder(19.99f, -20),
                new MatchOrder(29.99f, 100)));

        assertThat(result, is(expected));
        assertThat(result.get(0).value(), is(-20));
        assertThat(result.get(1).value(), is(100));
    }

    @Test
    public void whenAskOrderDoesNotMatchExistingBidOrderThenGetTwoOrders() {
        Book book = new Book("book");
        book.add(new Order("book", "BUY", 19.99f, 100, 1));
        book.add(new Order("book", "SELL", 29.99f, 20, 2));
        List<MatchOrder> result = book.asAskList();

        List<MatchOrder> expected = new ArrayList<>(Arrays.asList(
                new MatchOrder(19.99f, -100),
                new MatchOrder(29.99f, 20)));

        assertThat(result, is(expected));
        assertThat(result.get(0).value(), is(-100));
        assertThat(result.get(1).value(), is(20));
    }

    @Test
    public void whenBidOrderMatchesExistingAskOrderWithHigherPriceThenOrderIsExecuted() {
        Book book = new Book("book");
        book.add(new Order("book", "SELL", 10.0f, 100, 1));
        book.add(new Order("book", "BUY", 11.0f, 20, 2));
        List<MatchOrder> result = book.asAskList();

        List<MatchOrder> expected = new ArrayList<>(Arrays.asList(
                new MatchOrder(10.0f, 80)));

        assertThat(result, is(expected));
        assertThat(result.get(0).value(), is(80));
    }
}
