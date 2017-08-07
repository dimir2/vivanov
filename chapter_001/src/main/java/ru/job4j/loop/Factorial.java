package ru.job4j.loop;

/**
 * Class Factorial.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 07.08.2017
 */
public class Factorial {

    /**
     * Calculate the factorial of give number.
     * @param n Given number
     * @return Factorial of given number
     */
    public int calc(int n) {
        int factorial = 1;
        while (n > 1) {
            factorial *= n;
            n--;
        }
        return factorial;
    }
}
