package ru.job4j.pro.collections.orderbook.loader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.TreeSet;
import java.util.stream.Stream;

/**
 * Class ManualLoader.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 09.09.2017
 */
public class ManualLoader implements Loader {
    /**
     * Set of orders.
     */
    private final TreeSet<Order> orders;

    /**
     * Constructs ManualLoader.
     */
    private ManualLoader() {
        this.orders = new TreeSet<>();
    }

    /**
     * The other way to create an instance.
     *
     * @return ManualLoader object.
     */
    public static ManualLoader getInstance() {
        return new ManualLoader();
    }

    /**
     * Loads orders set from file.
     *
     * @param file XML file with orders.
     * @return Orders set.
     */
    @Override
    public TreeSet<Order> load(String file) {
        try {
            Stream<String> stream = Files.lines(Paths.get(new File(file).getPath()));
            stream.forEach(this::parse);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return orders;
    }

    /**
     * Parse XML string for the Order object.
     *
     * @param s XML string.
     */
    private void parse(String s) {
        if (s.startsWith("<A")) {
            orders.add(getOrder(s));
        } else if (s.startsWith("<D")) {
            orders.remove(getOrder(s));
        }
    }

    /**
     * Creates order object from xml line.
     *
     * @param s XML line.
     * @return Order object.
     */
    private Order getOrder(String s) {
        String[] val = new String[5];
        boolean start = false;
        int pos = -1;
        int cur = 0;
        for (int index = 0; index != s.length(); index++) {
            if (s.charAt(index) == '"') {
                if (!start) {
                    start = true;
                    pos = index;
                } else {
                    start = false;
                    val[cur++] = s.substring(pos + 1, index);
                }
            }
        }
        Order order;
        if (cur == 5) {
            order = new AddOrder(val[0], val[1], Float.valueOf(val[2]), Integer.valueOf(val[3]), Integer.valueOf(val[4]));
        } else {
            order = new DeleteOrder(val[0], Integer.valueOf(val[1]));
        }

        return order;
    }
}
