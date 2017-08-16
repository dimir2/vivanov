package ru.job4j.tracker;

/**
 * Class ValidateCondoleInput.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 16.08.2017
 */
public class ValidateConsoleInput extends ConsoleInput {

    /**
     * Ask a question with the predefined range of answers and return the answer.
     *
     * @param question Question to ask
     * @param range    Range of answers
     * @return Answer
     */
    @Override
    public int ask(String question, int[] range) throws MenuOutOfRangeException, NumberFormatException {
        int answer = super.ask(question, range);
        boolean exist = false;
        for (int key : range) {
            if (answer == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutOfRangeException("Menu out of range");
        }
        return answer;
    }
}
