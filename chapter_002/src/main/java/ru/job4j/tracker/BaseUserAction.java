package ru.job4j.tracker;

/**
 * Class BaseUserAction.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 16.08.2017
 */
public abstract class BaseUserAction implements UserAction {

    /**
     * Action key.
     */
    private int key;

    /**
     * Action title.
     */
    private String title;

    /**
     * Base action constructor.
     *
     * @param key   Action key
     * @param title Action title
     */
    public BaseUserAction(int key, String title) {
        this.key = key;
        this.title = title;
    }

    /**
     * Getter for the key.
     *
     * @return Action key
     */
    @Override
    public int key() {
        return this.key;
    }

    /**
     * Getter for the title.
     *
     * @return Action title
     */
    @Override
    public String title() {
        return this.title;
    }

    /**
     * Execute action.
     *
     * @param input   Input implementation.
     * @param tracker Tracker object
     * @return continue running flag
     */
    @Override
    public abstract boolean execute(Input input, Tracker tracker);

    /**
     * Show action information.
     *
     * @return String representing the action
     */
    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.title);
    }
}
