package ru.job4j.pro.collections.orderbook.loader;

import java.util.TreeSet;

/**
 * Interface Loader.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 09.09.2017
 */
public interface Loader {
    /**
     * Loads orders set from file.
     *
     * @param file XML file with orders.
     * @return Orders set.
     */
    TreeSet<Order> load(String file);
}
