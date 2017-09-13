package ru.job4j.pro.collections.generic.orderbook.tdd;

import org.junit.Test;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MatchedOrderTest {
    @Test
    public void whenCreateMatchedOrderThenItIsCreated() {
        MatchedOrder match = new MatchedOrder(19.99f, 100);
        assertThat(match, instanceOf(MatchedOrder.class));
    }

    @Test
    public void whenShiftMatchedOrderValueThenItIsShifted() {
        MatchedOrder match = new MatchedOrder(19.99f, 100);
        int result = match.shiftValue(-90);
        assertThat(result, is(10));
    }

    @Test
    public void whenTwoMatchedOrdersWithDifferentPriceThenTheyAreNotEqual() {
        MatchedOrder m1 = new MatchedOrder(19.99f, 100);
        MatchedOrder m2 = new MatchedOrder(10.99f, 100);
        assertFalse(m1.equals(m2));
    }

    @Test
    public void whenTwoMatchedOrdersWithTheSamePriceThenTheyAreEqual() {
        MatchedOrder m1 = new MatchedOrder(19.99f, 100);
        MatchedOrder m2 = new MatchedOrder(19.99f, 100);
        assertTrue(m1.equals(m2));
    }

    @Test
    public void whenTwoMatchedOrdersWithDifferentPriceThenHashCodesAreDifferent() {
        MatchedOrder m1 = new MatchedOrder(19.99f, 100);
        MatchedOrder m2 = new MatchedOrder(10.99f, 100);
        assertFalse(m1.hashCode() == m2.hashCode());
    }

    @Test
    public void whenTwoMatchedOrdersWithTheSamePriceThenHashCodesAreEqual() {
        MatchedOrder m1 = new MatchedOrder(19.99f, 100);
        MatchedOrder m2 = new MatchedOrder(19.99f, 100);
        assertTrue(m1.hashCode() == m2.hashCode());
    }

    @Test
    public void whenFirstPriceLessThanSecondThenCompareToReturnsValueLessThanZero() {
        MatchedOrder m1 = new MatchedOrder(10.99f, 100);
        MatchedOrder m2 = new MatchedOrder(19.99f, 100);
        assertTrue(m1.compareTo(m2) < 0);
    }

    @Test
    public void whenFirstPriceGreaterThanSecondThenCompareToReturnsValueGreaterThanZero() {
        MatchedOrder m1 = new MatchedOrder(19.99f, 100);
        MatchedOrder m2 = new MatchedOrder(10.99f, 100);
        assertTrue(m1.compareTo(m2) > 0);
    }

    @Test
    public void whenPricesAreEqualThenCompareToReturnsZero() {
        MatchedOrder m1 = new MatchedOrder(19.99f, 100);
        MatchedOrder m2 = new MatchedOrder(19.99f, 100);
        assertThat(m1.compareTo(m2), is(0));
    }

}