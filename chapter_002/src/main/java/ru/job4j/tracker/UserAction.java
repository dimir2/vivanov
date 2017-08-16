package ru.job4j.tracker;

/**
 * Interface UserInput.
 *
 * @author Vladimir Ivanov
 * @version 0.2
 * @since 16.08.2017
 */
public interface UserAction {

    /**
     * Key.
     *
     * @return Key
     */
    int key();

    /**
     * Getter for the title.
     *
     * @return Action title
     */
    String title();

    /**
     * Execute an action.
     *
     * @param input   Input implementation.
     * @param tracker Tracker object
     * @return do continue running
     */
    boolean execute(Input input, Tracker tracker);

    /**
     * Show action information.
     *
     * @return String representing the action.
     */
    String info();

}
