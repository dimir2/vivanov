package ru.job4j.coinsmachine;

import java.util.TreeSet;

/**
 * Class CoinsMachine.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 27.08.2017
 */
public class CoinsMachine {

    /**
     * Exchange banknote into coins.
     *
     * @param value Banknote value.
     * @return CoinsSet Set for exchangeFor.
     */
    public TreeSet<CoinsSet> exchangeWhile(int value) {
        TreeSet<CoinsSet> result = new TreeSet<>();
        for (Tens tens = new Tens(); tens.sum() <= value; tens = tens.addCoin()) {
            for (Fives fives = new Fives(); fives.sum() <= value - tens.sum(); fives = fives.addCoin()) {
                for (Twos twos = new Twos(); twos.sum() <= value - (tens.sum() + fives.sum()); twos = twos.addCoin()) {
                    result.add(new CoinsSet(tens, fives, twos, new Ones(value - (tens.sum() + fives.sum() + twos.sum()))));
                }
            }
        }
        return result;
    }
}
