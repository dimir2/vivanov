package ru.job4j.coinsmachine;

/**
 * Class Tens.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 27.08.2017
 */
public final class Tens extends Coins {
    /**
     * Constant value of tens.
     */
    private static final int VALUE = 10;

    /**
     * Construct tens coins with zero count.
     */
    public Tens() {
        this(0);
    }

    /**
     * Construct tens coins with given count.
     *
     * @param count Coins count.
     */
    public Tens(int count) {
        super(Tens.VALUE, count);
    }

    /**
     * Creates new tens coins object with count increased by one.
     *
     * @return New tens coins object with count increased by one.
     */
    @Override
    public Tens addCoin() {
        return new Tens(this.count + 1);
    }
}
