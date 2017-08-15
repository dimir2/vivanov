package ru.job4j.strategy;

/**
 * Class Triangle.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 15.08.2017
 */
public class Triangle implements Shape {

    /**
     * Draw triangle.
     *
     * @return String with triangle
     */
    @Override
    public String pic() {
        StringBuilder pic = new StringBuilder();
        pic.append("   *").append(System.lineSeparator());
        pic.append("  ***").append(System.lineSeparator());
        pic.append(" *****").append(System.lineSeparator());
        pic.append("*******");
        return pic.toString();
    }
}
