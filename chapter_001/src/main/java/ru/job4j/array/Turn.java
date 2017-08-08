package ru.job4j.array;

/**
 * Class Turn.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 07.08.2017
 */
public class Turn {

    /**
     * Turn back Array.
     * @param array initial array
     * @return reversed array
     */
    public int[] back(int[] array) {
        int middle = (int) array.length / 2;
        int last = array.length - 1;
        for (int i = 0; i < middle; i++) {
            int temp = array[i];
            array[i] = array[last - i];
            array[last - i] = temp;
        }
        return array;
    }
}
