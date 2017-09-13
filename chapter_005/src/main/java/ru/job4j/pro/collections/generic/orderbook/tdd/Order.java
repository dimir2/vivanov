package ru.job4j.pro.collections.generic.orderbook.tdd;

/**
 * Class Order.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 13.09.2017
 */
public class Order implements Comparable<Order> {
    /**
     * Order book.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public final String book;
    /**
     * Order op.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public final Op op;
    /**
     * Order price.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public final float price;
    /**
     * Order value.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public final int value;
    /**
     * Order id.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public final int id;

    /**
     * Constructs order.
     *
     * @param book  Order book.
     * @param op    Order op.
     * @param price Order price.
     * @param value Order value.
     * @param id    Order id.
     */
    public Order(String book, String op, float price, int value, int id) {
        this.book = book;
        this.op = Op.valueOf(op);
        this.price = price;
        this.value = value;
        this.id = id;
    }

    /**
     * Constructs delete order. Special object to find and delete order.
     *
     * @param book Order book.
     * @param id   Order id.
     */
    public Order(String book, int id) {
        this(book, null, 0, 0, id);
    }

    /**
     * Equality method for order objects.
     *
     * @param obj Object to compare with.
     * @return True if order ids are equal.
     */
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (this == obj) {
            result = true;
        } else {
            if (obj != null && getClass() == obj.getClass()) {
                Order order = (Order) obj;
                result = this.compareTo(order) == 0;
            }
        }
        return result;
    }

    /**
     * Hash code implementation for order object. As order ids are unique and integers, it returns just it.
     *
     * @return Order id.
     */
    @Override
    public int hashCode() {
        return id;
    }

    /**
     * Compares two objects. Checks the ids.
     *
     * @param other Order to compare with.
     * @return <0 if this  less than other,==00 if equals,>0 - greater than other.
     */
    @Override
    public int compareTo(Order other) {
        return id - other.id;
    }

}
