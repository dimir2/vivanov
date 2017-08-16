package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Class ConsoleInput.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 13.08.2017
 */
public class ConsoleInput implements Input {

    /**
     * Private object to interact with user.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Ask user a question and return his input.
     *
     * @param question Question to ask
     * @return User input
     */
    @Override
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**
     * Ask a question with the predefined range of answers and return the answer.
     *
     * @param question Question to ask
     * @param range    Range of answers
     * @return Answer
     */
    @Override
    public int ask(String question, int[] range) {
        return Integer.valueOf(this.ask(question));
    }
}
