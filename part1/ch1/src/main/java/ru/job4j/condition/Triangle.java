package ru.job4j.condition;

/**
 * Class Triangle.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 07.08.2017
 */
public class Triangle {

    /**
     * Point a (a.x, a.y).
     */
    private Point a;

    /**
     * Point b (b.x, b.y).
     */
    private Point b;

    /**
     * Point c (c.x, c.y).
     */
    private Point c;

    /**
     * Constructor of Triangle.
     *
     * @param a Point a
     * @param b Point b
     * @param c Point c
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Calculate area of triangle.
     * <p>
     * S = abs ( 1/2 * (b.x - a.x) * (c.y - a.y) - (c.x - a.x) * (b.y - a.y) )
     *
     * @return Area of triangle
     */
    public double area() {
        return Math.abs(((b.getX() - a.getX()) * (c.getY() - a.getY()) - (c.getX() - a.getX()) * (b.getY() - a.getY())) / 2);
    }
}
