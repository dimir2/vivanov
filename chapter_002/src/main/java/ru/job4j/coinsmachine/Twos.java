package ru.job4j.coinsmachine;

/**
 * Class Twos.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 27.08.2017
 */
public final class Twos extends Coins {
    /**
     * Constant value of twos.
     */
    private static final int VALUE = 2;

    /**
     * Construct twos coins with zero count.
     */
    public Twos() {
        this(0);
    }

    /**
     * Construct twos coins with given count.
     *
     * @param count Coins count.
     */
    public Twos(int count) {
        super(Twos.VALUE, count);
    }

    /**
     * Creates new twos coins object with count increased by one.
     *
     * @return New twos coins object with count increased by one.
     */
    @Override
    public Twos addCoin() {
        return new Twos(this.count + 1);
    }
}
