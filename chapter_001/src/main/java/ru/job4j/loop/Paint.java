package ru.job4j.loop;

/**
 * Class Paint.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 07.08.2017
 */
public class Paint {

    /**
     * Build the Piramid.
     *
     * @param height - Height of the Piramid
     * @return String representing the Piramid
     */
    public String piramid(int height) {
        StringBuilder sb = new StringBuilder();
        int width = 2 * height - 1;
        for (int h = 1; h <= height; h++) {

            for (int w = height - h; w > 0; w--) {
                sb.append(' ');
            }
            for (int b = 2 * h - 1; b > 0; b--) {
                sb.append('^');
            }
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }
}
