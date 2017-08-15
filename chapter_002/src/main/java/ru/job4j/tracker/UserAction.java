package ru.job4j.tracker;

/**
 * Interface UserInput.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 15.08.2017
 */
public interface UserAction {

    /**
     * Key.
     *
     * @return Key
     */
    int key();

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
