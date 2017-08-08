package ru.job4j.array;

/**
 * Class BubbleSort.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 08.08.2017
 */
public class BubbleSort {

    /**
     * Bubble sort.
     *
     * @param array Initial array
     * @return sorted array
     */
    public int[] sort(int[] array) {
        int last = array.length - 1;
        for (int i = 0; i < last; i++) {
            for (int j = 0; j < last - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
