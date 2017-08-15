package ru.job4j.tracker;

import java.util.Arrays;

/**
 * Class TrackerMenu.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 15.08.2017
 */
public class TrackerMenu {
    /**
     * Tracker object.
     */
    private final Tracker tracker;

    /**
     * Input interface implementation.
     */
    private final Input input;

    /**
     * User Actions.
     */
    private UserAction[] userActions = new UserAction[7];

    /**
     * Constructor of Menu.
     *
     * @param input   Input implementation.
     * @param tracker Tracker object
     */
    public TrackerMenu(Input input, Tracker tracker) {
        this.tracker = tracker;
        this.input = input;
        this.fillMenu();
    }

    /**
     * Prettify menu title string.
     *
     * @param title Menu title
     * @return Pretty menu title
     */
    public static String menuTitle(String title) {
        StringBuilder builder = new StringBuilder(50);
        builder.append(System.lineSeparator());
        builder.append(title).append(System.lineSeparator());
        for (int i = 0; i < title.length(); i++) {
            builder.append('-');
        }
        builder.append(System.lineSeparator());
        return builder.toString();
    }

    /**
     * Show menu.
     */
    public void show() {
        System.out.println(TrackerMenu.menuTitle("Tracker Main Menu"));
        for (UserAction action : this.userActions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Execute chosen action.
     *
     * @param key String representing action key.
     * @return do continue running
     */
    public boolean choice(String key) {
        boolean continueRunning = true;
        int choice;
        try {
            choice = Integer.valueOf(key);
            if (choice >= 0 && choice < this.userActions.length && this.userActions[choice] != null) {
                continueRunning = this.userActions[choice].execute(this.input, this.tracker);
            } else {
                System.out.println("Could not get your choice.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Could not get your choice.");
        }
        return continueRunning;
    }

    /**
     * Fill menu with the user actions.
     */
    public void fillMenu() {
        userActions[1] = this.new AddNewItem(1, "Add new item");
        userActions[2] = new TrackerMenu.ShowAllItems(2, "Show all items");
        userActions[3] = this.new EditItem(3, "Edit item");
        userActions[4] = this.new DeleteItem(4, "Delete item");
        userActions[5] = this.new FindItemById(5, "Find item by ID");
        userActions[6] = this.new FindItemsByName(6, "Find items by name");
        userActions[0] = new ExitProgram(0, "Exit program");
    }

    /**
     * Show all items action implementation.
     */
    private static class ShowAllItems implements UserAction {

        /**
         * Key by which this action can be executed.
         */
        private int key;

        /**
         * Title of this action.
         */
        private String title;

        /**
         * Constructor of the action.
         *
         * @param key   Action key
         * @param title Action title
         */
        ShowAllItems(int key, String title) {
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
         * Executor for the action.
         *
         * @param input   Input implementation object.
         * @param tracker Tracker object
         * @return do continue running
         */
        @Override
        public boolean execute(Input input, Tracker tracker) {
            System.out.println(TrackerMenu.menuTitle(title));

            Item[] items = tracker.findAll();
            System.out.println("total count - " + items.length);
            for (int i = 0; i < items.length; i++) {
                System.out.print(i + ") ");
                System.out.print(items[i].toString());
            }
            return true;
        }

        /**
         * Show all action information.
         *
         * @return String representing show all items action
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key, this.title);
        }
    }

    /**
     * Add new item action implementation.
     */
    private class AddNewItem implements UserAction {

        /**
         * Key by which this action can be executed.
         */
        private int key;

        /**
         * Title of this action.
         */
        private String title;

        /**
         * Constructor of the action.
         *
         * @param key   Action key
         * @param title Action title
         */
        AddNewItem(int key, String title) {
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
         * Executor for the action.
         *
         * @param input   Input implementation object.
         * @param tracker Tracker object
         * @return do continue running
         */
        @Override
        public boolean execute(Input input, Tracker tracker) {
            System.out.println(TrackerMenu.menuTitle(title));

            String name = "";
            while (name.isEmpty()) {
                name = input.ask("Item name: ");
            }

            String desc = "";
            while (desc.isEmpty()) {
                desc = input.ask("Item description: ");
            }

            String comment = "";
            comment = input.ask("Item comment (optional): ");

            String[] comments = (comment.isEmpty()) ? new String[]{} : new String[]{comment};

            tracker.add(new Item(name, desc, comments));
            return true;
        }

        /**
         * Add new item action information.
         *
         * @return String representing the action
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key, this.title);
        }
    }

    /**
     * Edit item action implementation.
     */
    private class EditItem implements UserAction {
        /**
         * Key by which this action can be executed.
         */
        private int key;
        /**
         * Title of this action.
         */
        private String title;

        /**
         * Constructor of the action.
         *
         * @param key   Action key
         * @param title Action title
         */
        EditItem(int key, String title) {
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
         * Executor for the action.
         *
         * @param input   Input implementation object.
         * @param tracker Tracker object
         * @return do continue running
         */
        @Override
        public boolean execute(Input input, Tracker tracker) {
            System.out.println(TrackerMenu.menuTitle(title));

            String id = input.ask("Enter item id to edit: ");
            Item item = tracker.findById(id);

            if (item == null) {
                System.out.println("Could not found item with ID: " + id);
            } else {
                System.out.println("Item:");
                System.out.println(item.toString());

                String name = input.ask("Item name: ");
                if (!name.isEmpty()) {
                    item.setName(name);
                }

                String desc = input.ask("Item description: ");
                if (!desc.isEmpty()) {
                    item.setDesc(desc);
                }

                String comment = "";
                comment = input.ask("Item comment (optional): ");
                if (!comment.isEmpty()) {
                    String[] oldComments = item.getComments();
                    String[] newComments = Arrays.copyOf(oldComments, oldComments.length + 1);
                    newComments[newComments.length - 1] = comment;
                    item.setComments(newComments);
                }
            }
            return true;
        }

        /**
         * Edit item action information.
         *
         * @return String representing edit item action
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key, this.title);
        }
    }

    /**
     * Delete item action implementation.
     */
    private class DeleteItem implements UserAction {

        /**
         * Key by which this action can be executed.
         */
        private int key;

        /**
         * Title of this action.
         */
        private String title;

        /**
         * Constructor of the action.
         *
         * @param key   Action key
         * @param title Action title
         */
        DeleteItem(int key, String title) {
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
         * Executor for the action.
         *
         * @param input   Input implementation object.
         * @param tracker Tracker object
         * @return do continue running
         */
        @Override
        public boolean execute(Input input, Tracker tracker) {
            System.out.println(TrackerMenu.menuTitle(title));

            String id = input.ask("Enter item ID: ");
            Item item = tracker.findById(id);
            if (item == null) {
                System.out.println("Could not found item with ID " + id);
            } else {
                tracker.delete(item);
            }
            return true;
        }

        /**
         * Delete item action information.
         *
         * @return String representing delete item action
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key, this.title);
        }
    }

    /**
     * Find item by id action implementation.
     */
    private class FindItemById implements UserAction {

        /**
         * Key by which this action can be executed.
         */
        private int key;

        /**
         * Title of this action.
         */
        private String title;

        /**
         * Constructor of the action.
         *
         * @param key   Action key
         * @param title Action title
         */
        FindItemById(int key, String title) {
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
         * Executor for the action.
         *
         * @param input   Input implementation object.
         * @param tracker Tracker object
         * @return do continue running
         */
        @Override
        public boolean execute(Input input, Tracker tracker) {
            System.out.println(TrackerMenu.menuTitle(title));

            String id = input.ask("Enter item ID: ");
            Item item = tracker.findById(id);
            if (item == null) {
                System.out.println("Could not found item with ID " + id);
            } else {
                System.out.println(item.toString());
            }
            return true;
        }

        /**
         * Find item by ID action information.
         *
         * @return String representing the action
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key, this.title);
        }
    }

    /**
     * Find items by name action implementation.
     */
    private class FindItemsByName implements UserAction {

        /**
         * Key by which this action can be executed.
         */
        private int key;

        /**
         * Title of this action.
         */
        private String title;

        /**
         * Constructor of the action.
         *
         * @param key   Action key
         * @param title Action title
         */
        FindItemsByName(int key, String title) {
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
         * Executor for the action.
         *
         * @param input   Input implementation object.
         * @param tracker Tracker object
         * @return do continue running
         */
        @Override
        public boolean execute(Input input, Tracker tracker) {
            System.out.println(TrackerMenu.menuTitle(title));

            String name = input.ask("Enter item name: ");
            Item[] items = tracker.findByName(name);
            System.out.println(items.length + " items found:");
            for (Item item : items) {
                System.out.println(item.toString());
            }
            return true;
        }

        /**
         * Find item by name action information.
         *
         * @return String representing the action
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key, this.title);
        }
    }
}

/**
 * Exit program action implementation.
 */
class ExitProgram implements UserAction {

    /**
     * Key by which this action can be executed.
     */
    private int key;

    /**
     * Title of this action.
     */
    private String title;

    /**
     * Constructor of the action.
     *
     * @param key   Action key
     * @param title Action title
     */
    ExitProgram(int key, String title) {
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
     * Executor for the action.
     *
     * @param input   Input implementation object.
     * @param tracker Tracker object
     * @return do continue running
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("Goodbye!");
        return false;
    }

    /**
     * Exit program action information.
     *
     * @return String representing the action
     */
    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.title);
    }
}