package ru.job4j.pro.collections.orderbook.tdd;

import org.junit.Test;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MatchOrderTest {
    @Test
    public void whenCreateMatchedOrderThenItIsCreated() {
        MatchOrder match = new MatchOrder(19.99f, 100);
        assertThat(match, instanceOf(MatchOrder.class));
    }

    @Test
    public void whenShiftMatchedOrderValueThenItIsShifted() {
        MatchOrder match = new MatchOrder(19.99f, 100);
        int result = match.shiftValue(-90);
        assertThat(result, is(10));
    }

    @Test
    public void whenTwoMatchedOrdersWithDifferentPriceThenTheyAreNotEqual() {
        MatchOrder m1 = new MatchOrder(19.99f, 100);
        MatchOrder m2 = new MatchOrder(10.99f, 100);
        assertFalse(m1.equals(m2));
    }

    @Test
    public void whenTwoMatchedOrdersWithTheSamePriceThenTheyAreEqual() {
        MatchOrder m1 = new MatchOrder(19.99f, 100);
        MatchOrder m2 = new MatchOrder(19.99f, 100);
        assertTrue(m1.equals(m2));
    }

    @Test
    public void whenTwoMatchedOrdersWithDifferentPriceThenHashCodesAreDifferent() {
        MatchOrder m1 = new MatchOrder(19.99f, 100);
        MatchOrder m2 = new MatchOrder(10.99f, 100);
        assertFalse(m1.hashCode() == m2.hashCode());
    }

    @Test
    public void whenTwoMatchedOrdersWithTheSamePriceThenHashCodesAreEqual() {
        MatchOrder m1 = new MatchOrder(19.99f, 100);
        MatchOrder m2 = new MatchOrder(19.99f, 100);
        assertTrue(m1.hashCode() == m2.hashCode());
    }

    @Test
    public void whenFirstPriceLessThanSecondThenCompareToReturnsValueLessThanZero() {
        MatchOrder m1 = new MatchOrder(10.99f, 100);
        MatchOrder m2 = new MatchOrder(19.99f, 100);
        assertTrue(m1.compareTo(m2) < 0);
    }

    @Test
    public void whenFirstPriceGreaterThanSecondThenCompareToReturnsValueGreaterThanZero() {
        MatchOrder m1 = new MatchOrder(19.99f, 100);
        MatchOrder m2 = new MatchOrder(10.99f, 100);
        assertTrue(m1.compareTo(m2) > 0);
    }

    @Test
    public void whenPricesAreEqualThenCompareToReturnsZero() {
        MatchOrder m1 = new MatchOrder(19.99f, 100);
        MatchOrder m2 = new MatchOrder(19.99f, 100);
        assertThat(m1.compareTo(m2), is(0));
    }

}