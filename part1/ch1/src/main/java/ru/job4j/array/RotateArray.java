package ru.job4j.array;

/**
 * Class RotateArray.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 08.08.2017
 */
public class RotateArray {

    /**
     * Rotate 2 dim array clockwise.
     *
     * @param array Initial array
     * @return Rotated array
     */
    public int[][] rotate(int[][] array) {

        int last = array[0].length - 1;
        int half = (int) array[0].length / 2;
        int[] temp = {0, 0};
        for (int i = 0; i < half; i++) {
            for (int j = i; j < last - i; j++) {
                int[] row = {i, 0};
                int[] col = {j, 0};
                temp[0] = array[row[0]][col[0]];
                for (int k = 0; k < 4; k++) {
                    temp[1] = temp[0];
                    row[1] = col[0];
                    col[1] = last - row[0];

                    temp[0] = array[row[1]][col[1]];
                    array[row[1]][col[1]] = temp[1];
                    row[0] = row[1];
                    col[0] = col[1];
                }
            }
        }
        return array;
    }

    /**
     * Rotate 2 dim array clockwise simplified.
     *
     * @param array Initial array
     * @return Rotated array
     */
    public int[][] rotateSimple(int[][] array) {

        int len = array.length;
        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - i - 1; j++) {
                int temp = array[i][j];
                array[i][j] = array[len - j - 1][i];
                array[len - j - 1][i] = array[len - i - 1][len - j - 1];
                array[len - i - 1][len - j - 1] = array[j][len - i - 1];
                array[j][len - i - 1] = temp;
            }
        }
        return array;
    }

    /**
     * Rotate 2 dim array clockwise using copy array.
     *
     * @param array Initial array
     * @return Rotated array
     */
    public int[][] rotateCopy(int[][] array) {
        int len = array.length;
        int[][] result = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                result[j][len - i - 1] = array[i][j];
            }
        }
        return result;
    }

}
