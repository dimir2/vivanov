package ru.job4j.tracker;

import java.util.Arrays;

/**
 * Class StarUI.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 13.08.2017
 */
public class StartUI {

    /**
     * Exit choice (always zero to allow menu modifications without renumbering it).
     */
    private static final String EXIT = "0";

    /**
     * Add item choice.
     */
    private static final String ADD = "1";

    /**
     * Show all items choice.
     */
    private static final String SHOW_ALL = "2";

    /**
     * Edit item chice.
     */
    private static final String EDIT = "3";

    /**
     * Delete item choice.
     */
    private static final String DELETE = "4";

    /**
     * Find item y ID choice.
     */
    private static final String FIND_BY_ID = "5";

    /**
     * Find item y name choice.
     */
    private static final String FIND_BY_NAME = "6";
    /**
     * Tracker object.
     */
    private final Tracker tracker;
    /**
     * Input interface console implementation.
     */
    private Input input = new ConsoleInput();
    /**
     * User menu holder.
     */
    private String menu = this.createMenu();

    /**
     * StartUI constructor.
     *
     * @param tracker Tracker to use
     */
    public StartUI(Tracker tracker) {
        this.tracker = tracker;
    }

    /**
     * Entry point to Tracker.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        new StartUI(new Tracker()).init();
    }

    /**
     * Create main tracker menu.
     *
     * @return String representation of main menu
     */
    private String createMenu() {
        StringBuilder sb = new StringBuilder();
        String lineSep = System.lineSeparator();
        String dotSep = ". ";
        sb.append("Tracker main menu").append(lineSep);
        sb.append(ADD).append(dotSep).append("Add new item").append(lineSep);
        sb.append(SHOW_ALL).append(dotSep).append("Show all items").append(lineSep);
        sb.append(EDIT).append(dotSep).append("Edit item").append(lineSep);
        sb.append(DELETE).append(dotSep).append("Delete item").append(lineSep);
        sb.append(FIND_BY_ID).append(dotSep).append("Find item by ID").append(lineSep);
        sb.append(FIND_BY_NAME).append(dotSep).append("Find item by name").append(lineSep);
        sb.append(EXIT).append(dotSep).append("Exit programm").append(lineSep);

        return sb.toString();
    }

    /**
     * Main loop of the user interface.
     */
    public void init() {
        boolean running = true;
        while (running) {
            System.out.print(this.menu);
            String choice = this.input.ask("Select: ");
            switch (choice) {
                case EXIT:
                    running = false;
                    break;
                case ADD:
                    this.addNewItem();
                    break;
                case SHOW_ALL:
                    this.showAllItems();
                    break;
                case EDIT:
                    this.editItem();
                    break;
                case DELETE:
                    this.deleteItem();
                    break;
                case FIND_BY_ID:
                    this.findItemById();
                    break;
                case FIND_BY_NAME:
                    this.findItemByName();
                    break;
                default:
                    System.out.println("Could not get your input. Please try again.");
                    break;
            }
        }
    }

    /**
     * Add new item user interaction.
     */
    private void addNewItem() {

        System.out.println("Add new item dialog");

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

        this.tracker.add(new Item(name, desc, comments));
    }

    /**
     * Show all items.
     */
    private void showAllItems() {

        System.out.println("All items list");
        System.out.println("===");

        Item[] items = this.tracker.findAll();
        for (int i = 0; i < items.length; i++) {
            System.out.print(i + ") ");
            System.out.println(items[i].toString());
        }
    }

    /**
     * Edit item user interaction.
     */
    private void editItem() {

        System.out.println("Edit item dialog");
        System.out.println("===");

        String id = input.ask("Enter item id to edit: ");
        Item item = tracker.findById(id);

        if (item == null) {
            System.out.println("Item with ID " + id + " is not found in tracker");
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
    }

    /**
     * Delete item user interaction.
     */
    private void deleteItem() {

        System.out.println("Delete item dialog");
        System.out.println("===");

        String id = input.ask("Enter item id to delete: ");
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("Item with ID " + id + " is not found in tracker");
        } else {
            tracker.delete(item);
        }
    }

    /**
     * Find item by ID user interaction.
     */
    private void findItemById() {

        System.out.println("Find item by ID dialog");
        System.out.println("===");

        String id = input.ask("Enter item id to find: ");
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("Item with ID " + id + " is not found in tracker");
        } else {
            System.out.println(item.toString());
        }
    }

    /**
     * Find item by name user interaction.
     */
    private void findItemByName() {

        System.out.println("Find item by name dialog");
        System.out.println("===");

        String id = input.ask("Enter item name to find: ");
        Item[] items = tracker.findByName(id);
        System.out.println(items.length + " items found in tracker:");
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }

}
