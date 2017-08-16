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
     * Range of menu choices.
     */
    private int[] menuRange;

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
        this.fillMenuRange();
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
        return builder.toString();
    }

    /**
     * Prettify menu action result.
     *
     * @param result Menu action result
     * @return Pretty menu title
     */
    public static String menuActionResult(String result) {
        StringBuilder builder = new StringBuilder(50);
        builder.append(menuSep()).append(System.lineSeparator());
        builder.append(result).append(System.lineSeparator()).append(menuSep());
        return builder.toString();
    }

    /**
     * Menu separator.
     *
     * @return menu separator
     */
    public static String menuSep() {
        return "  ----";
    }

    /**
     * Show menu.
     */
    public void show() {
        System.out.println(menuTitle("Tracker Menu"));

        for (int index = 1; index < this.userActions.length; index++) {
            if (userActions[index] != null) {
                System.out.println(userActions[index].info());
            }
        }
        System.out.println(menuSep());
        if (userActions[0] != null) {
            System.out.println(userActions[0].info());
        }
        System.out.println(menuSep());
    }

    /**
     * Execute chosen action.
     *
     * @param key Action key.
     * @return do continue running.
     */
    public boolean choice(int key) {
        return this.userActions[key].execute(this.input, this.tracker);
    }

    /**
     * Fill menu with the user actions.
     */
    private void fillMenu() {
        userActions[1] = this.new AddNewItem(1, "Add new item");
        userActions[2] = new TrackerMenu.ShowAllItems(2, "Show all items");
        userActions[3] = this.new EditItem(3, "Edit item");
        userActions[4] = this.new DeleteItem(4, "Delete item");
        userActions[5] = this.new FindItemById(5, "Find item by id");
        userActions[6] = this.new FindItemsByName(6, "Find items by name");
        userActions[0] = new ExitProgram(0, "Exit program");
    }

    /**
     * Fill menu range.
     */
    private void fillMenuRange() {
        int[] range = new int[this.userActions.length];
        int index = 0;
        for (UserAction action : this.userActions) {
            if (action != null) {
                range[index++] = action.key();
            }
        }
        if (index != this.userActions.length) {
            range = Arrays.copyOf(range, index);
        }
        this.menuRange = range;
    }

    /**
     * Getter for the menu range.
     *
     * @return Menu range
     */
    public int[] getMenuRange() {
        return this.menuRange;
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
            System.out.println(menuTitle(title));

            Item[] items = tracker.findAll();
            System.out.println(menuActionResult(String.format("items (total %s):", items.length)));
            for (Item item : items) {
                System.out.println(item.toString());
                System.out.println(menuSep());
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
                name = input.ask("please enter name: ");
            }

            String desc = "";
            while (desc.isEmpty()) {
                desc = input.ask("please enter desc: ");
            }

            String comment = "";
            comment = input.ask("please enter comment (optional): ");

            String[] comments = (comment.isEmpty()) ? new String[]{} : new String[]{comment};

            Item item = tracker.add(new Item(name, desc, comments));

            System.out.println(menuActionResult("item added successfully"));
            System.out.println(item.toString());
            System.out.println(menuSep());
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

            String id = input.ask("please enter item id: ");
            Item item = tracker.findById(id);

            if (item == null) {
                System.out.println(menuActionResult("could not find item with id: " + id));
            } else {
                System.out.println("item:");
                System.out.println(item.toString());

                String name = input.ask("please enter new name: ");
                if (!name.isEmpty()) {
                    item.setName(name);
                }

                String desc = input.ask("please enter new desc: ");
                if (!desc.isEmpty()) {
                    item.setDesc(desc);
                }

                String comment = "";
                comment = input.ask("please add comment (optional): ");
                if (!comment.isEmpty()) {
                    String[] oldComments = item.getComments();
                    String[] newComments = Arrays.copyOf(oldComments, oldComments.length + 1);
                    newComments[newComments.length - 1] = comment;
                    item.setComments(newComments);
                }

                System.out.println(menuActionResult("item updated successfully"));
                System.out.println(item.toString());
                System.out.println(menuSep());
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

            String id = input.ask("please enter item id: ");
            Item item = tracker.findById(id);
            if (item == null) {
                System.out.println(menuActionResult("could not find item with id " + id));
            } else {
                tracker.delete(item);
                System.out.println(menuActionResult("item deleted successfully"));
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

            String id = input.ask("please enter item id: ");
            Item item = tracker.findById(id);
            if (item == null) {
                System.out.println(menuActionResult("could not find item with id " + id));
            } else {
                System.out.println(menuActionResult("found item: "));
                System.out.println(item.toString());
                System.out.println(menuSep());
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

            String name = input.ask("please enter item name: ");
            Item[] items = tracker.findByName(name);
            System.out.println(menuActionResult(String.format("items found: (%d)", items.length)));
            for (Item item : items) {
                System.out.println(item.toString());
                System.out.println(menuSep());
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
        System.out.println(TrackerMenu.menuSep());
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