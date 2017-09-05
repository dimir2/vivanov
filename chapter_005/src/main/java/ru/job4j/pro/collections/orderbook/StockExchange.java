package ru.job4j.pro.collections.orderbook;

import ru.job4j.pro.collections.orderbook.loader.Order;
import ru.job4j.pro.collections.orderbook.loader.OrderBookLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Class StockExchange.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 06.09.2017
 */
public class StockExchange {
    /**
     * Orders set.
     */
    private TreeSet<Order> orders;
    /**
     * Order books.
     */
    private Map<String, OrderBook> books;

    /**
     * Constructs StockExchange object.
     */
    public StockExchange() {
        this.books = new HashMap<>();
    }

    /**
     * Loads orders set from file.
     *
     * @param file XML file with orders.
     */
    public void loadOrders(String file) {
        this.orders = OrderBookLoader.getInstance().load(file);

        for (Order order : this.orders) {
            String book = order.getBook();
            if (!this.books.containsKey(book)) {
                this.books.put(book, new OrderBook(book));
            }
            this.books.get(book).newOrder(order);
        }
    }

    /**
     * String representation of StockExchange status.
     *
     * @return String with StockExchange status.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String book : new TreeSet<>(this.books.keySet())) {
            sb.append(books.get(book).toString());
        }
        return sb.toString();
    }
}
