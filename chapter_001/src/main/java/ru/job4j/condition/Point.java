package ru.job4j.condition;

/**
 * Class Point.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 07.08.2017
 */
public class Point {

    /**
     * Hold X coordinate of Point.
     */
    private int x;
    /**
     * Hold Y coordinate of Point.
     */
    private int y;

    /**
     * Point Constructor.
     *
     * @param x X coordinate of Point
     * @param y Y coordinate of Point
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter fot the X coordinate of Point.
     *
     * @return X coordinate of Point
     */
    public int getX() {
        return x;
    }

    /**
     * Getter fot the Y coordinate of Point.
     *
     * @return Y coordinate for Point
     */
    public int getY() {
        return y;
    }

    /**
     * Check if the Point is placed on the line, described with the equation y = a * x + b.
     *
     * @param a Parameter of the line equation
     * @param b Parameter of the line equation
     * @return true, if the point belongs the line, false otherwise
     */
    public boolean is(int a, int b) {
        return this.y == a * this.x + b;
    }
}
