package ru.job4j.pro.collections.generic.orderbook.tdd;

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
        List<MatchedOrder> result = book.asList();

        List<MatchedOrder> expected = new ArrayList<>(Arrays.asList(new MatchedOrder(19.99f, 100)));
        assertThat(result, is(expected));
    }

    @Test
    public void whenAddTwoOrdersWithSamePriceThenValuesSumUp() {
        Book book = new Book("book");
        book.add(new Order("book", "SELL", 19.99f, 100, 1));
        book.add(new Order("book", "SELL", 19.99f, 20, 2));
        List<MatchedOrder> result = book.asList();

        List<MatchedOrder> expected = new ArrayList<>(Arrays.asList(new MatchedOrder(19.99f, 120)));

        assertThat(result, is(expected));
        assertThat(result.get(0).getValue(), is(120));
    }

    @Test
    public void whenAddTwoOrdersWithSamePriceDifferentOperationThenValuesSumUp() {
        Book book = new Book("book");
        book.add(new Order("book", "SELL", 19.99f, 100, 1));
        book.add(new Order("book", "BUY", 19.99f, 20, 2));
        List<MatchedOrder> result = book.asList();

        List<MatchedOrder> expected = new ArrayList<>(Arrays.asList(new MatchedOrder(19.99f, 80)));

        assertThat(result, is(expected));
        assertThat(result.get(0).getValue(), is(80));
    }
}
