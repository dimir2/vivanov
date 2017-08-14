package ru.job4j.tracker;

/**
 * Class StubInput.
 * <p>
 * Emulates user input during unit tests
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 14.08.2013
 */
public class StubInput implements Input {

    /**
     * Answers to emulate user input.
     */
    private String[] answers;

    /**
     * Counter for answer.
     */
    private int counter;

    /**
     * Constructor. Fill the answer array.
     *
     * @param answers Predefined user answers
     */
    public StubInput(String[] answers) {
        this.answers = answers;
        this.counter = 0;
    }

    /**
     * Return the answer predefined in constructor.
     *
     * @param question Question to ask
     * @return
     */
    @Override
    public String ask(String question) {
        return this.answers[counter++];
    }
}
