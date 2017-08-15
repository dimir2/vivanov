package ru.job4j.strategy;

/**
 * Class Square.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 15.08.2017
 */
public class Square implements Shape {

    /**
     * Draw square.
     *
     * @return String with square
     */
    @Override
    public String pic() {
        StringBuilder pic = new StringBuilder();
        pic.append("*****").append(System.lineSeparator());
        pic.append("*****").append(System.lineSeparator());
        pic.append("*****").append(System.lineSeparator());
        pic.append("*****").append(System.lineSeparator());
        pic.append("*****");
        return pic.toString();
    }
}