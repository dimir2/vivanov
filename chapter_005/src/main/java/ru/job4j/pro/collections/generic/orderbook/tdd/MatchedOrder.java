package ru.job4j.pro.collections.generic.orderbook.tdd;

/**
 * Class MatchedOrder.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 13.09.2017
 */
public class MatchedOrder implements Comparable<MatchedOrder> {
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
    public MatchedOrder(float price, int value) {
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
                MatchedOrder that = (MatchedOrder) obj;
                result = this.compareTo(that) == 0;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        return (price != +0.0f ? Float.floatToIntBits(price) : 0);
    }

    public float getPrice() {
        return price;
    }

    public int getValue() {
        return value;
    }

    public int shiftValue(int shift) {
        return this.value += shift;
    }

    @Override
    public int compareTo(MatchedOrder that) {
        return Float.compare(price, that.price);
    }
}
