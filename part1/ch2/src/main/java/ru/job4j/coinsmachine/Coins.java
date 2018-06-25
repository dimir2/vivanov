package ru.job4j.coinsmachine;

/**
 * Class Coins.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 27.08.2017
 */
public abstract class Coins implements Comparable {
    /**
     * Coins value.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public final int value;
    /**
     * Coins count.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public final int count;

    /**
     * Construct coins set of one value.
     *
     * @param value Coins value.
     * @param count Coins count.
     */
    public Coins(int value, int count) {
        this.value = value;
        this.count = count;
    }

    /**
     * Calculate sum of coins set.
     *
     * @return Coins sum.
     */
    public int sum() {
        return this.value * this.count;
    }

    /**
     * Creates new coins object with count increased by one.
     *
     * @return New coins object with count increased by one.
     */
    public abstract Coins addCoin();

    /**
     * Equality method implementation for Coins.
     *
     * @param obj Object to test.
     * @return True if equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (this == obj) {
            result = true;
        } else {
            if (obj instanceof Coins) {
                Coins coins = (Coins) obj;
                result = (value == coins.value && count == coins.count);
            }
        }
        return result;
    }

    /**
     * hashCode implementation for Coins.
     *
     * @return hashCode.
     */
    @Override
    public int hashCode() {
        return 31 * value + count;
    }

    @Override
    public int compareTo(Object obj) {
        Coins coins = (Coins) obj;
        int result = Integer.compare(value, coins.value);
        if (result == 0) {
            result = Integer.compare(count, coins.count);
        }
        return result;
    }
}
