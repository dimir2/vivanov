package ru.job4j.pro.collections;

import java.util.Iterator;

/**
 * EvenArray class.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 25.08.2017
 */
public class EvenArray {
    /**
     * Array of ints.
     */
    private int[] array;

    /**
     * Construct even array.
     *
     * @param array Array of ints.
     */
    EvenArray(int[] array) {
        this.array = array;
    }

    /**
     * Get array iterator.
     *
     * @return Even array iterator.
     */
    Iterator<Integer> iterator() {
        return new EvenIt(this.array);
    }
}
