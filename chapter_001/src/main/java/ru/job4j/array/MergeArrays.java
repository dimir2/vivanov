package ru.job4j.array;

/**
 * Class Merge Arrays.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 13.08.2017
 */
public class MergeArrays {

    /**
     * Merge two sorted arrays of int into one sorted array.
     *
     * @param left  Left sorted array
     * @param right Right sorted array
     * @return Merged sorted array
     */
    public int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int l = 0;
        int r = 0;
        int i = 0;
        while (i < result.length) {
            if (l < left.length && r < right.length) {
                if (left[l] < right[r]) {
                    result[i] = left[l++];
                } else {
                    result[i] = right[r++];
                }
            } else {
                if (r == right.length) {
                    result[i] = left[l++];
                } else {
                    result[i] = right[r++];
                }
            }
            i++;
        }
        return result;
    }
}
