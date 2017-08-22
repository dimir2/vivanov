package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Class TrackerMenu.
 *
 * @author Vladimir Ivanov
 * @version 0.2
 * @since 16.08.2017
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
    private List<UserAction> userActions = new ArrayList<>();

    /**
     * Range of menu choices.
     */
    private List<Integer> menuRange;

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

        for (int index = 1; index < this.userActions.size(); index++) {
            if (userActions.get(index) != null) {
                System.out.println(userActions.get(index).info());
            }
        }
        System.out.println(menuSep());
        if (userActions.get(0) != null) {
            System.out.println(userActions.get(0).info());
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
        return this.userActions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Fill menu with the user actions.
     */
    private void fillMenu() {
        userActions.add(0, new BaseUserAction(0, "Exit program") {
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
        });
        userActions.add(1, this.new AddNewItem(1, "Add new item"));
        userActions.add(2, new TrackerMenu.ShowAllItems(2, "Show all items"));
        userActions.add(3, this.new EditItem(3, "Edit item"));
        userActions.add(4, this.new DeleteItem(4, "Delete item"));
        userActions.add(5, this.new FindItemById(5, "Find item by id"));
        userActions.add(6, this.new FindItemsByName(6, "Find items by name"));
    }

    /**
     * Fill menu range.
     */
    private void fillMenuRange() {
        List<Integer> range = new ArrayList<>();
        for (UserAction action : this.userActions) {
            if (action != null) {
                range.add(action.key());
            }
        }
        this.menuRange = range;
    }

    /**
     * Getter for the menu range.
     *
     * @return Menu range
     */
    public List<Integer> getMenuRange() {
        return this.menuRange;
    }

    /**
     * Show all items action implementation.
     */
    private static class ShowAllItems extends BaseUserAction {

        /**
         * Constructor of the action.
         *
         * @param key   Action key
         * @param title Action title
         */
        ShowAllItems(int key, String title) {
            super(key, title);
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
            System.out.println(menuTitle(this.title()));

            List<Item> items = tracker.findAll();
            System.out.println(menuActionResult(String.format("items (total %s):", items.size())));
            for (Item item : items) {
                System.out.println(item.toString());
                System.out.println(menuSep());
            }
            return true;
        }
    }

    /**
     * Add new item action implementation.
     */
    private class AddNewItem extends BaseUserAction {
        /**
         * Constructor of the action.
         *
         * @param key   Action key
         * @param title Action title
         */
        AddNewItem(int key, String title) {
            super(key, title);
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
            System.out.println(TrackerMenu.menuTitle(this.title()));

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

            if (comment.isEmpty()) {
                comment = null;
            }
            Item item = tracker.add(new Item(name, desc, comment));

            System.out.println(menuActionResult("item added successfully"));
            System.out.println(item.toString());
            System.out.println(menuSep());
            return true;
        }
    }

    /**
     * Edit item action implementation.
     */
    private class EditItem extends BaseUserAction {
        /**
         * Constructor of the action.
         *
         * @param key   Action key
         * @param title Action title
         */
        EditItem(int key, String title) {
            super(key, title);
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
            System.out.println(TrackerMenu.menuTitle(this.title()));

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
                    item.addComment(comment);
                }

                System.out.println(menuActionResult("item updated successfully"));
                System.out.println(item.toString());
                System.out.println(menuSep());
            }
            return true;
        }
    }

    /**
     * Delete item action implementation.
     */
    private class DeleteItem extends BaseUserAction {
        /**
         * Constructor of the action.
         *
         * @param key   Action key
         * @param title Action title
         */
        DeleteItem(int key, String title) {
            super(key, title);
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
            System.out.println(TrackerMenu.menuTitle(this.title()));

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
    }

    /**
     * Find item by id action implementation.
     */
    private class FindItemById extends BaseUserAction {

        /**
         * Constructor of the action.
         *
         * @param key   Action key
         * @param title Action title
         */
        FindItemById(int key, String title) {
            super(key, title);
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
            System.out.println(TrackerMenu.menuTitle(this.title()));

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
    }

    /**
     * Find items by name action implementation.
     */
    private class FindItemsByName extends BaseUserAction {

        /**
         * Constructor of the action.
         *
         * @param key   Action key
         * @param title Action title
         */
        FindItemsByName(int key, String title) {
            super(key, title);
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
            System.out.println(TrackerMenu.menuTitle(this.title()));

            String name = input.ask("please enter item name: ");
            List<Item> items = tracker.findByName(name);
            System.out.println(menuActionResult(String.format("items found: (%d)", items.size())));
            for (Item item : items) {
                System.out.println(item.toString());
                System.out.println(menuSep());
            }
            return true;
        }
    }
}
