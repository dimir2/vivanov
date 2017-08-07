package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Class TriangleTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 07.08.2017
 */
public class TriangleTest {
    /**
     * Simple Triangle test.
     */
    @Test
    public void whenThreeFourFiveThenGetSix() {
        Triangle tri = new Triangle(new Point(1, 4), new Point(5, 1), new Point(1, 1));
        double area = tri.area();
        assertThat(area, closeTo(6d, 0.1d));
    }

    /**
     * Isosceles Triangle test.
     */
    @Test
    public void whenIsoscelesTriangleThenGetEight() {
        Triangle tri = new Triangle(new Point(1, 1), new Point(3, 3), new Point(5, 1));
        double area = tri.area();
        assertThat(area, closeTo(4d, 0.1d));
    }
}