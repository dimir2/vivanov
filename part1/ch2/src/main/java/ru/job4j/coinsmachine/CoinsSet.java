package ru.job4j.coinsmachine;

import java.util.Objects;

/**
 * Class CoinsSet.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 27.08.2017
 */
public final class CoinsSet implements Comparable {
    /**
     * Tens Coins.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public final Coins tens;
    /**
     * Fives Coins.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public final Coins fives;
    /**
     * Twos Coins.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public final Coins twos;
    /**
     * Ones Coins.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public final Coins ones;

    /**
     * Construct Coins Set.
     *
     * @param tens  Tens Coins.
     * @param fives Fives Coins.
     * @param twos  Twos Coins.
     * @param ones  Ones Coins.
     */
    public CoinsSet(Tens tens, Fives fives, Twos twos, Ones ones) {
        this.tens = tens;
        this.fives = fives;
        this.twos = twos;
        this.ones = ones;
    }

    /**
     * Equality method implementation for CoinsSet.
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
            if (obj instanceof CoinsSet) {
                CoinsSet coinsSet = (CoinsSet) obj;
                result = Objects.equals(tens, coinsSet.tens)
                        && Objects.equals(fives, coinsSet.fives)
                        && Objects.equals(twos, coinsSet.twos)
                        && Objects.equals(ones, coinsSet.ones);
            }
        }
        return result;
    }

    /**
     * hashCode implementation for CoinsSet.
     *
     * @return hashCode.
     */
    @Override
    public int hashCode() {
        int result = tens != null ? tens.hashCode() : 0;
        result = 31 * result + (fives != null ? fives.hashCode() : 0);
        result = 31 * result + (twos != null ? twos.hashCode() : 0);
        result = 31 * result + (ones != null ? ones.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Object obj) {
        CoinsSet coins = (CoinsSet) obj;
        int result = tens.compareTo(coins.tens);
        if (result == 0) {
            result = fives.compareTo(coins.fives);
            if (result == 0) {
                result = twos.compareTo(coins.twos);
                if (result == 0) {
                    result = ones.compareTo(coins.ones);
                }
            }
        }
        return result;
    }
}
