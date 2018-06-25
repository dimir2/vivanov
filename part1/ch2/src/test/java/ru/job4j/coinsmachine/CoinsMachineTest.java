package ru.job4j.coinsmachine;

import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

/**
 * Class CoinsMachine Test.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 27.08.2017
 */
public class CoinsMachineTest {
    /**
     * Test banknote with value 3 exchange.
     */
    @Test
    public void whenBanknoteValueIsThreeThenGetAllPossibleExchangeSets() {
        int banknote = 3;
        CoinsMachine machine = new CoinsMachine();

        TreeSet<CoinsSet> expected = new TreeSet<>();
        expected.add(new CoinsSet(new Tens(0), new Fives(0), new Twos(0), new Ones(3)));
        expected.add(new CoinsSet(new Tens(0), new Fives(0), new Twos(1), new Ones(1)));

        TreeSet<CoinsSet> result = machine.exchangeWhile(banknote);

        assertEquals(expected, result);
    }

    /**
     * Test banknote with value 6 exchange.
     */
    @Test
    public void whenBanknoteValueIsSexThenGetAllPossibleExchangeSets() {
        int banknote = 6;
        CoinsMachine machine = new CoinsMachine();

        TreeSet<CoinsSet> expected = new TreeSet<>();
        expected.add(new CoinsSet(new Tens(0), new Fives(0), new Twos(0), new Ones(6)));
        expected.add(new CoinsSet(new Tens(0), new Fives(0), new Twos(1), new Ones(4)));
        expected.add(new CoinsSet(new Tens(0), new Fives(0), new Twos(2), new Ones(2)));
        expected.add(new CoinsSet(new Tens(0), new Fives(0), new Twos(3), new Ones(0)));
        expected.add(new CoinsSet(new Tens(0), new Fives(1), new Twos(0), new Ones(1)));

        TreeSet<CoinsSet> result = machine.exchangeWhile(banknote);

        assertEquals(expected, result);
    }

    /**
     * Test banknote with value 10 exchange.
     */
    @Test
    public void whenBanknoteValueIsTenThenGetAllPossibleExchangeSets() {
        int banknote = 10;
        CoinsMachine machine = new CoinsMachine();

        TreeSet<CoinsSet> expected = new TreeSet<>();
        expected.add(new CoinsSet(new Tens(0), new Fives(0), new Twos(0), new Ones(10)));
        expected.add(new CoinsSet(new Tens(0), new Fives(0), new Twos(1), new Ones(8)));
        expected.add(new CoinsSet(new Tens(0), new Fives(0), new Twos(2), new Ones(6)));
        expected.add(new CoinsSet(new Tens(0), new Fives(0), new Twos(3), new Ones(4)));
        expected.add(new CoinsSet(new Tens(0), new Fives(0), new Twos(4), new Ones(2)));
        expected.add(new CoinsSet(new Tens(0), new Fives(0), new Twos(5), new Ones(0)));
        expected.add(new CoinsSet(new Tens(0), new Fives(1), new Twos(0), new Ones(5)));
        expected.add(new CoinsSet(new Tens(0), new Fives(1), new Twos(1), new Ones(3)));
        expected.add(new CoinsSet(new Tens(0), new Fives(1), new Twos(2), new Ones(1)));
        expected.add(new CoinsSet(new Tens(0), new Fives(2), new Twos(0), new Ones(0)));
        expected.add(new CoinsSet(new Tens(1), new Fives(0), new Twos(0), new Ones(0)));


        TreeSet<CoinsSet> result = machine.exchangeWhile(banknote);

        assertEquals(expected, result);
    }
}
