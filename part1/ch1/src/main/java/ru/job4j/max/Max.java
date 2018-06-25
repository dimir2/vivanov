package ru.job4j.max;

/**
 * Class Max.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 07.08.2017
 */
public class Max {

    /**
     * max method. Return maximum from two given integers.
     *
     * @param first  First parameter.
     * @param second Second parameter.
     * @return Maximum parameter
     * @author Vladimir Ivanov
     * @since 07.08.2017
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * max method. Return maximum from three given integers.
     *
     * @param first  First parameter.
     * @param second Second parameter.
     * @param third  Third parameter.
     * @return Maximum parameter
     * @author Vladimir Ivanov
     * @since 07.08.2017
     */
    public int max(int first, int second, int third) {
        return max(max(first, second), third);
    }
}
