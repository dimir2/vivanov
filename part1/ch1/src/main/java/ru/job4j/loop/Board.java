package ru.job4j.loop;

/**
 * Class Board.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 07.08.2017
 */
public class Board {

    /**
     * Paint the board of specified dimensions.
     * @param width Width of the board
     * @param height Height of the board
     * @return String containg the board
     */
    public String paint(int width, int height) {
        StringBuilder sb = new StringBuilder();
        char start = 'x';
        for (int i = 0; i < height; i++) {
            char next = start;
            for (int j = 0; j < width; j++) {
                sb.append(next);
                next = (next == 'x') ? ' ' : 'x';
            }
            sb.append(System.getProperty("line.separator"));
            start = (start == 'x') ? ' ' : 'x';
        }
        return sb.toString();
    }
}
