package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Class ChapterQuizTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 09.08.2017
 */
public class ChapterQuizTest {

    /**
     * Test contains method (original starts with the sub).
     *
     * @author Vladimir Ivanov
     * @since 09.08.2017
     */
    @Test
    public void whenOriginalStartsWithSubstringThenTrue() {
        ChapterQuiz quiz = new ChapterQuiz();
        boolean result = quiz.contains("Welcome!", "Wel");
        assertThat(result, is(true));
    }

    /**
     * Test contains method (original ends with the sub).
     *
     * @author Vladimir Ivanov
     * @since 09.08.2017
     */
    @Test
    public void whenOriginalEndsWithSubstringThenTrue() {
        ChapterQuiz quiz = new ChapterQuiz();
        boolean result = quiz.contains("Welcome!", "come");
        assertThat(result, is(true));
    }

    /**
     * Test contains method (original contains the sub).
     *
     * @author Vladimir Ivanov
     * @since 09.08.2017
     */
    @Test
    public void whenOriginalContainsSubstringThenTrue() {
        ChapterQuiz quiz = new ChapterQuiz();
        boolean result = quiz.contains("Welcome to Java!", "to");
        assertThat(result, is(true));
    }

    /**
     * Test contains method (original does not contain the sub).
     *
     * @author Vladimir Ivanov
     * @since 09.08.2017
     */
    @Test
    public void whenOriginalDoesNotContainSubstringThenFalse() {
        ChapterQuiz quiz = new ChapterQuiz();
        boolean result = quiz.contains("Welcome to Java!", "Europe");
        assertThat(result, is(false));
    }

}