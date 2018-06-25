package ru.job4j.tracker;

import java.util.List;

/**
 * Interface Input.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 13.08.2017
 */
public interface Input {

    /**
     * Ask a question and return the answer.
     *
     * @param question Question to ask
     * @return Answer
     */
    String ask(String question);

    /**
     * Ask a question with the predefined range of answers and return the answer.
     *
     * @param question Question to ask
     * @param range    Range of answers
     * @return Answer
     */
    int ask(String question, List<Integer> range);
}

