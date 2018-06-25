package ru.job4j.loop;

/**
 * Class Counter.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 07.08.2017
 */
public class Counter {

    /**
     * Calculate sum of even numbers in range.
     *
     * @param start  Start of range
     * @param finish Finish of range
     * @return Calculated sum
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
