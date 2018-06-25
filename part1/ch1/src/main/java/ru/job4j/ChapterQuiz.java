package ru.job4j;

/**
 * Class ChapterQuiz for module 001.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 09.08.2017
 */
public class ChapterQuiz {

    /**
     * Check if if original contains sub string.
     *
     * @param origin Original string
     * @param sub    String to find in original one.
     * @return True if original contains sub string
     */
    public boolean contains(String origin, String sub) {
        boolean result = false;
        char[] o = origin.toCharArray();
        char[] s = sub.toCharArray();
        for (int i = 0; i <= o.length - s.length; i++) {
            int k = 0;
            while (k < s.length && o[i + k] == s[k]) {
                k++;
            }
            if (k == s.length) {
                result = true;
                break;
            }
        }

        return result;
    }
}
