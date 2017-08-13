package ru.job4j.tracker;

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
}

