package ru.job4j.pro.collections.generic.orderbook.tdd;

/**
 * Enum Op.
 */
public enum Op {
    /**
     * Buy op.
     */
    BUY(-1),
    /**
     * Sell op.
     */
    SELL(1);

    private final int sign;

    /**
     * Creates an op.
     *
     * @param sign Sign of op.
     */
    Op(int sign) {
        this.sign = sign;
    }

    /**
     * Sign of op.
     *
     * @return Sign.
     */
    public int sign() {
        return this.sign;
    }
}
