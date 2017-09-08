package ru.job4j.pro.collections.map;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class Catalogue.
 *
 * @param <K> Key object.
 * @param <V> Value object.
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 01.09.2017
 */
public class Catalogue<K, V> {
    /**
     * Default container capacity.
     */
    private static final int DEFAULT_CAPACITY = 1 << 4;
    /**
     * Default load factor.
     */
    private static final double DEFAULT_LOAD_FACTOR = 0.75D;
    /**
     * Dynamic array of nodes.
     */
    private Entry<K, V>[] array;
    /**
     * Amount of elements added.
     */
    private int size;

    /**
     * Constructs Catalogue with default capacity.
     */
    public Catalogue() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs Catalogue with given capacity.
     *
     * @param capacity Initial capacity.
     */
    @SuppressWarnings("unchecked")
    public Catalogue(int capacity) {
        this.array = new Entry[(capacity > DEFAULT_CAPACITY) ? capacity : DEFAULT_CAPACITY];
    }

    /**
     * Returns size of Catalogue.
     *
     * @return Size.
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns iterator on Catalogue.
     *
     * @return Iterator.
     */
    public Iterator<Entry<K, V>> iterator() {
        return new Iterator<Entry<K, V>>() {
            private int current = 0;

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (array != null) {
                    while (array.length > current) {
                        if (array[current] != null) {
                            result = true;
                            break;
                        }
                        current++;
                    }
                }
                return result;
            }

            @Override
            public Entry<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[current++];
            }
        };
    }

    /**
     * Inserts pair K,V into the Catalogue.
     *
     * @param key   Key.
     * @param value Value.
     * @return Result of insertion.
     */
    public boolean insert(K key, V value) {
        boolean result = false;
        int hash = this.hash(key);
        int index = this.hashToIndex(hash);
        if (this.array[index] == null) {
            Entry<K, V> entry = new Entry<>(hash, key, value);
            this.array[index] = entry;
            this.maybeRebuildArray();
            result = true;
        }
        return result;
    }

    /**
     * Get value based on key.
     *
     * @param key Key.
     * @return Value.
     */
    public V get(K key) {
        V result = null;
        int hash = this.hash(key);
        int index = this.hashToIndex(hash);
        if (this.array[index] != null) {
            result = this.array[index].value;
        }
        return result;
    }

    /**
     * Deletes pair from Catalogue.
     *
     * @param key Key.
     * @return Result of the deletion.
     */
    public boolean delete(K key) {
        boolean result = false;
        int hash = this.hash(key);
        int index = this.hashToIndex(hash);
        if (this.array[index] != null) {
            this.array[index] = null;
            result = true;
        }
        return result;
    }

    /**
     * Rebuild array when the threshold is broken.
     * TODO implement it right.
     */
    private void maybeRebuildArray() {
        int threshold = (int) (this.array.length * DEFAULT_LOAD_FACTOR);
        if (this.size() >= threshold) {
            this.array = this.array;
        }
    }

    /**
     * Calculates hash for the key object.
     *
     * @param key Key.
     * @return Hash.
     */
    private int hash(K key) {
        int hash = 0;
        if (key != null) {
            int h = key.hashCode();
            hash = h ^ (h >>> 16);
        }
        return hash;
    }

    /**
     * Converts key hash to array index.
     *
     * @param hash Key hash.
     * @return Bin index.
     */
    private int hashToIndex(int hash) {
        return hash % this.array.length;
    }

    /**
     * Class Entry.
     *
     * @param <K> Key.
     * @param <V> Value.
     */
    static class Entry<K, V> {
        /**
         * Key object.
         */
        @SuppressWarnings("checkstyle:visibilitymodifier")
        final K key;
        /**
         * Key hash.
         */
        private final int hash;
        /**
         * Value object.
         */
        @SuppressWarnings("checkstyle:visibilitymodifier")
        V value;

        /**
         * Constructs entry object.
         *
         * @param hash  Key hash.
         * @param key   Key.
         * @param value Value.
         */
        Entry(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        /**
         * Equality check.
         *
         * @param other Other object to check against.
         * @return Result of equality check.
         */
        @Override
        public boolean equals(Object other) {
            boolean result = false;
            if (this == other) {
                result = true;
            } else {
                if (other instanceof Entry) {
                    Entry<?, ?> entry = (Entry<?, ?>) other;
                    if (hash == entry.hash) {
                        if (key != null ? key.equals(entry.key) : entry.key == null) {
                            result = value != null ? value.equals(entry.value) : entry.value == null;
                        }
                    }
                }
            }
            return result;
        }

        /**
         * Entry hashCode.
         *
         * @return hashCode.
         */
        @Override
        public int hashCode() {
            int result = hash;
            result = 31 * result + (key != null ? key.hashCode() : 0);
            result = 31 * result + (value != null ? value.hashCode() : 0);
            return result;
        }
    }
}
