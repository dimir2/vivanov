package ru.job4j.light;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.Random;

import static java.lang.String.format;

/**
 * Class CollectionTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 20.08.2017
 */
public class CollectionTest {

    /**
     * Maximum number of strings to store in Collections during this test.
     */
    private static final int MAX_STRINGS = 1_505_000;

    /**
     * Main entry point.
     *
     * @param args Arguments (not used here)
     */
    public static void main(String[] args) {

        CollectionTest test = new CollectionTest();

        for (int amount = 500_000; amount < MAX_STRINGS; amount += 200_000) {
            Map<String, Collection<String>> map = new LinkedHashMap<>();
            map.put("LinkedList", new LinkedList<String>());
            map.put("ArrayList", new ArrayList<String>());
            map.put("TreeSet", new TreeSet<String>());

            System.out.println(format("Test: add %d strings", amount));
            for (String collection : map.keySet()) {
                System.out.print(format("Collection under test: %16s. Time: ", collection));
                System.out.println(format("%6d millis.", test.add(map.get(collection), amount)));
            }
            System.out.println();
            System.out.println(format("Test: delete %d strings", amount / 4));
            for (String collection : map.keySet()) {
                System.out.print(format("Collection under test: %16s. Time: ", collection));
                System.out.println(format("%6d millis.", test.delete(map.get(collection), amount / 4)));
            }
            System.out.println();
        }
    }

    /**
     * Add great amount of strings into the Collection.
     *
     * @param collection Collection under test.
     * @param amount     Amount of strings.
     * @return Time in milliseconds to execute the operation.
     */
    public long add(Collection<String> collection, int amount) {
        Instant start = Instant.now();
        for (int index = 0; index < amount; index++) {
            collection.add(UUID.randomUUID().toString() + ":" + getSaltString());
        }
        Instant end = Instant.now();
        return Duration.between(start, end).toMillis();
    }

    /**
     * Remove first amount of strings from the Collection.
     *
     * @param collection Collection under test.
     * @param amount     Amount of strings.
     * @return Time in milliseconds to execute the operation.
     */
    public long delete(Collection<String> collection, int amount) {
        Instant start = Instant.now();
        for (int index = 0; index < amount; index++) {
            if (collection instanceof TreeSet<?>) {
                ((TreeSet<String>) collection).pollFirst();
            } else if (collection instanceof List<?>) {
                ((List<String>) collection).remove(0);
            }
        }
        Instant end = Instant.now();
        return Duration.between(start, end).toMillis();
    }

    /**
     * Generate random string.
     *
     * @return Random string
     */
    private String getSaltString() {
        String saltChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * saltChars.length());
            salt.append(saltChars.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}
