package ru.job4j.array;

import java.util.Arrays;

/**
 * Class ArrayDuplicate.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 08.08.2017
 */
public class ArrayDuplicate {

    /**
     * Remove duplicates from array of Strings.
     *
     * @param array Initial array
     * @return Trancated array
     */
    public String[] remove(String[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            int j = i + 1;
            while (j < len) {
                if (array[i].equals(array[j])) {
                    for (int k = j; k < len - 1; k++) {
                        array[k] = array[k + 1];
                    }
                    len--;
                } else {
                    j++;
                }
            }
        }
        return Arrays.copyOf(array, len);
    }
}
