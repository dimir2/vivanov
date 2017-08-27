package ru.job4j.coinsmachine;

/**
 * Class Ones.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 27.08.2017
 */
public final class Ones extends Coins {
    /**
     * Constant value of ones.
     */
    private static final int VALUE = 1;

    /**
     * Construct ones coins with zero count.
     */
    public Ones() {
        this(0);
    }

    /**
     * Construct ones coins with given count.
     *
     * @param count Coins count.
     */
    public Ones(int count) {
        super(Ones.VALUE, count);
    }

    /**
     * Creates new ones coins object with count increased by one.
     *
     * @return New ones coins object with count increased by one.
     */
    @Override
    public Ones addCoin() {
        return new Ones(this.count + 1);
    }
}
