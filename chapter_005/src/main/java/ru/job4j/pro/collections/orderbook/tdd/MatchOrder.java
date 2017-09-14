package ru.job4j.pro.collections.orderbook.tdd;

/**
 * Class MatchOrder.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 13.09.2017
 */
public class MatchOrder implements Comparable<MatchOrder> {
    /**
     * Matched order price.
     */
    private final float price;
    /**
     * Matched order value.
     */
    private int value;

    /**
     * Constructs matched order.
     *
     * @param price Price.
     * @param value Value.
     */
    public MatchOrder(float price, int value) {
        this.price = price;
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (this == obj) {
            result = true;
        } else {
            if (obj != null && getClass() == obj.getClass()) {
                MatchOrder that = (MatchOrder) obj;
                result = this.compareTo(that) == 0;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        return (price != +0.0f ? Float.floatToIntBits(price) : 0);
    }

    public float price() {
        return price;
    }

    public int value() {
        return value;
    }

    public int shiftValue(int shift) {
        return this.value += shift;
    }

    @Override
    public int compareTo(MatchOrder that) {
        return Float.compare(price, that.price);
    }
}
