package ru.job4j.pro.collections.orderbook.loader;

/**
 * Class Order.
 *
 * @author Vladimir Ivanov
 * @version 0.3
 * @since 06.09.2017
 */
public abstract class Order implements Comparable<Order> {
    /**
     * Order book.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    String book;
    /**
     * Order price.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    float price;
    /**
     * Order operation.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    String operation;
    /**
     * Order volume.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    int volume;
    /**
     * Order id.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    int orderId;

    /**
     * Constructs order.
     *
     * @param book      Order book.
     * @param operation Order operation.
     * @param price     Order price.
     * @param volume    Order volume.
     * @param orderId   Order id.
     */
    public Order(String book, String operation, float price, int volume, int orderId) {
        this.book = book;
        this.price = price;
        this.operation = operation;
        this.volume = volume;
        this.orderId = orderId;
    }

    /**
     * Default non-arg constructor is required.
     */
    public Order() {
    }

    /**
     * Getter for order book.
     *
     * @return Order book.
     */
    public String getBook() {
        return book;
    }

    /**
     * Getter for order id.
     *
     * @return Order id.
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Getter for order price.
     *
     * @return Order price.
     */
    public float getPrice() {
        return price;
    }

    /**
     * Getter for order volume.
     *
     * @return Order volume.
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Getter for order op.
     *
     * @return Order op.
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Equality method.
     *
     * @param obj Other Order object.
     * @return True if ids are equal.
     */
    public boolean equals(Object obj) {
        boolean result = false;
        if (this == obj) {
            result = true;
        } else {
            if (obj instanceof Order) {
                result = compareTo((Order) obj) == 0;
            }
        }
        return result;
    }

    /**
     * Hash code based on order id.
     *
     * @return Hash code.
     */
    @Override
    public int hashCode() {
        return orderId;
    }

    @Override
    public int compareTo(Order obj) {
        return Integer.compare(orderId, obj.orderId);
    }
}
