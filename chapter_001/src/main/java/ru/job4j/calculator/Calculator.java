package ru.job4j.calculator;

/**
 * Class Calculator.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 07.08.2017
 */
public class Calculator {

    /**
     * Internal field to hold the last operation result.
     */
    private double result;

    /**
     * Calculator constructor.
     *
     * @author Vladimir Ivanov
     * @since 07.08.2017
     */
    public Calculator() {
        this.result = 0d;
    }

    /**
     * Add method. Add two doubles and save the result internally.
     *
     * @param first  First parameter.
     * @param second Second parameter.
     * @author Vladimir Ivanov
     * @since 07.08.2017
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Subtract method. Subtract second double from the first one and save the result internally.
     *
     * @param first  First parameter.
     * @param second Second parameter.
     * @author Vladimir Ivanov
     * @since 07.08.2017
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Divide method. Divide first double by second one and save the result internally.
     *
     * @param first  First parameter.
     * @param second Second parameter.
     * @author Vladimir Ivanov
     * @since 07.08.2017
     */
    public void divide(double first, double second) {
        this.result = first / second;
    }

    /**
     * Multiply method. Multiply first double by second one and save the result internally.
     *
     * @param first  First parameter.
     * @param second Second parameter.
     * @author Vladimir Ivanov
     * @since 07.08.2017
     */
    public void multiply(double first, double second) {
        this.result = first * second;
    }

    /**
     * Getter for the result of last operation.
     *
     * @return result Last operation result.
     * @author Vladimir Ivanov
     * @since 07.08.2017
     */
    public double getResult() {
        return this.result;
    }
}
