package ru.job4j.tracker;

import java.util.List;

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
     * Range of the tracker menu choices.
     */
    private List<Integer> menuRange;

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
        new StartUI(new ValidateConsoleInput(), new Tracker()).init();
    }

    /**
     * Main loop of the user interface.
     */
    public void init() {
        TrackerMenu menu = new TrackerMenu(this.input, this.tracker);
        menuRange = menu.getMenuRange();
        boolean continueRunning = true;
        int actionKey;
        do {
            menu.show();
            try {
                actionKey = this.input.ask("Select: ", menu.getMenuRange());
            } catch (MenuOutOfRangeException me) {
                System.out.println(TrackerMenu.menuActionResult("please select key from menu."));
                continue;
            } catch (NumberFormatException ne) {
                System.out.println(TrackerMenu.menuActionResult("please enter valid menu key."));
                continue;
            }
            continueRunning = menu.choice(actionKey);

        } while (continueRunning);
    }
}
