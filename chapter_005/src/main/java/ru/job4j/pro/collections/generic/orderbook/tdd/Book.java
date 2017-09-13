package ru.job4j.pro.collections.generic.orderbook.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Class Book.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 13.09.2017
 */
public class Book {
    /**
     * Book name.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public final String name;

    private final TreeSet<MatchedOrder> set;

    /**
     * Creates book.
     *
     * @param name Book name.
     */
    public Book(String name) {
        this.name = name;
        this.set = new TreeSet<>();
    }

    /**
     * Adds order to book.
     *
     * @param order Order.
     * @return True if added.
     */
    public boolean add(Order order) {
        boolean result = true;
        MatchedOrder match = new MatchedOrder(order.price, order.op.sign() * order.value);
        if (this.set.contains(match)) {
            MatchedOrder found = this.set.ceiling(match);
            found.shiftValue(match.getValue());
        } else {
            result = this.set.add(match);
        }
        return result;
    }

    public List<MatchedOrder> asList() {
        List<MatchedOrder> result = new ArrayList<>(this.set);
        return result;
    }
}
