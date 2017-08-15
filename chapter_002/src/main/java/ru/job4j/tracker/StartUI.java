package ru.job4j.tracker;

/**
 * Class StarUI.
 *
 * @author Vladimir Ivanov
 * @version 0.2
 * @since 13.08.2017
 */
public class StartUI {

    /**
     * Input interface console implementation.
     */
    private final Input input;

    /**
     * Tracker object.
     */
    private final Tracker tracker;

    /**
     * StartUI constructor.
     *
     * @param input   User input implementation
     * @param tracker Tracker object
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Entry point to Tracker.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

    /**
     * Main loop of the user interface.
     */
    public void init() {
        TrackerMenu menu = new TrackerMenu(this.input, this.tracker);
        do {
            menu.show();
        } while (menu.choice(this.input.ask("Select: ")));
    }
}
