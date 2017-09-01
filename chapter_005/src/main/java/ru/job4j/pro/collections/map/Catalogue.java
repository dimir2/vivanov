package ru.job4j.pro.collections.map;

import java.util.HashMap;

public class Catalogue<K, V> {
    private static final int DEFAULT_CAPACITY = 1 << 4;
    private static final double DEFAULT_LOAD_FACTOR = 0.75D;
    private Node<K, V>[] array;
    private int size;

    private static class Node<K, V> {
        K key;
        V value;

        boolean isEmpty() {
            return key == null;
        }
    }
}
