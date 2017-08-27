package ru.job4j.coinsmachine;

/**
 * Class Fives.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 27.08.2017
 */
public final class Fives extends Coins {
    /**
     * Constant value of fives.
     */
    private static final int VALUE = 5;

    /**
     * Construct fives coins with zero count.
     */
    public Fives() {
        this(0);
    }

    /**
     * Construct fives coins with given count.
     *
     * @param count Coins count.
     */
    public Fives(int count) {
        super(Fives.VALUE, count);
    }

    /**
     * Creates new fives coins object with count increased by one.
     *
     * @return New fives coins object with count increased by one.
     */
    @Override
    public Fives addCoin() {
        return new Fives(this.count + 1);
    }
}
