package ru.job4j.pro.collections.orderbook.loader;

import org.junit.Test;

import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class OrderBookLoaderTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 07.09.2017
 */
public class OrderBookLoaderTest {
    /**
     * Test simple order book loading with AddOrder actions and one book.
     */
    @Test
    public void whenSimpleOrderBookGivenThenItIsLoaded() {
        ClassLoader classLoader = getClass().getClassLoader();
        String file = classLoader.getResource("orders-004.xml").getFile();

        OrderBookLoader loader = OrderBookLoader.getInstance();
        TreeSet<Order> result = loader.load(file);

        TreeSet<Order> expected = new TreeSet<>();
        expected.add(new AddOrder("book-1", "SELL", 100.50f, 81, 1));
        expected.add(new AddOrder("book-1", "BUY", 99.50f, 86, 2));
        expected.add(new AddOrder("book-1", "BUY", 99.70f, 16, 3));
        expected.add(new AddOrder("book-1", "SELL", 100.00f, 80, 4));

        assertThat(result, is(expected));
    }

    /**
     * Test simple order book loading with AddOrder actions and several books.
     */
    @Test
    public void whenLoadTwelveOrdersThenTheyAreLoaded() {
        ClassLoader classLoader = getClass().getClassLoader();
        String file = classLoader.getResource("orders-012.xml").getFile();

        OrderBookLoader loader = OrderBookLoader.getInstance();
        TreeSet<Order> result = loader.load(file);

        TreeSet<Order> expected = new TreeSet<>();
        expected.add(new AddOrder("book-1", "SELL", 100.50f, 81, 1));
        expected.add(new AddOrder("book-3", "BUY", 99.50f, 86, 2));
        expected.add(new AddOrder("book-1", "BUY", 99.70f, 16, 3));
        expected.add(new AddOrder("book-3", "SELL", 100.00f, 80, 4));
        expected.add(new AddOrder("book-2", "SELL", 100.50f, 79, 5));
        expected.add(new AddOrder("book-2", "BUY", 99.40f, 78, 6));
        expected.add(new AddOrder("book-3", "SELL", 100.00f, 82, 7));
        expected.add(new AddOrder("book-2", "SELL", 100.20f, 42, 8));
        expected.add(new AddOrder("book-3", "SELL", 100.40f, 75, 9));
        expected.add(new AddOrder("book-1", "BUY", 99.80f, 64, 10));
        expected.add(new AddOrder("book-2", "SELL", 100.50f, 46, 11));
        expected.add(new AddOrder("book-3", "SELL", 100.00f, 48, 12));

        assertThat(result, is(expected));
    }

    /**
     * Test simple order book loading with add/delete actions and several books.
     */
    @Test
    public void whenLoadAddDeleteOrdersThenTheyAreLoaded() {
        ClassLoader classLoader = getClass().getClassLoader();
        String file = classLoader.getResource("orders-012-del.xml").getFile();

        OrderBookLoader loader = OrderBookLoader.getInstance();
        TreeSet<Order> result = loader.load(file);

        TreeSet<Order> expected = new TreeSet<>();
        expected.add(new AddOrder("book-1", "SELL", 100.50f, 81, 1));
        expected.add(new AddOrder("book-3", "BUY", 99.50f, 86, 2));
        expected.add(new AddOrder("book-3", "SELL", 100.00f, 80, 4));
        expected.add(new AddOrder("book-2", "SELL", 100.50f, 79, 5));
        expected.add(new AddOrder("book-3", "SELL", 100.00f, 82, 7));
        expected.add(new AddOrder("book-2", "SELL", 100.20f, 42, 8));
        expected.add(new AddOrder("book-2", "SELL", 100.50f, 46, 11));
        expected.add(new AddOrder("book-3", "SELL", 100.00f, 48, 12));

        assertThat(result, is(expected));
    }

}