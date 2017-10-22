package ru.job4j.multithreading.threads;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class WordSpaceCountTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 22.10.2017
 */
public class WordSpaceCountTest {
    /**
     * Counting words in a file.
     */
    @Test
    public void whenRunWordCountOnFileThenGetWordCount() {
        String fname = getClass().getClassLoader().getResource("test_10_words_10_spaces.txt").getPath();
        WordSpaceCount ws = new WordSpaceCount();
        int result = ws.wordCount(fname);
        assertThat(result, is(10));
    }

    /**
     * Counting words in Alice file.
     */
    @Test
    public void whenRunWordCountOnAliceThenGetWordCount() {
        String fname = getClass().getClassLoader().getResource("alice.txt").getPath();
        WordSpaceCount ws = new WordSpaceCount();
        int result = ws.wordCount(fname);
        assertThat(result, is(27342));
    }

    /**
     * Counting spaces in a file.
     */
    @Test
    public void whenRunSpaceCountOnFileThenGetSpaceCount() {
        String fname = getClass().getClassLoader().getResource("test_10_words_10_spaces.txt").getPath();
        WordSpaceCount ws = new WordSpaceCount();
        int result = ws.spaceCount(fname);
        assertThat(result, is(10));
    }

    /**
     * Counting spaces in a file.
     */
    @Test
    public void whenRunSpaceCountOnAliceThenGetSpaceCount() {
        String fname = getClass().getClassLoader().getResource("alice.txt").getPath();
        WordSpaceCount ws = new WordSpaceCount();
        int result = ws.spaceCount(fname);
        assertThat(result, is(28918));
    }
}