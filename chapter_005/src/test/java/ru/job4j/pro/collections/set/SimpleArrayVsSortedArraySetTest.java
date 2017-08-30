package ru.job4j.pro.collections.set;

import org.junit.Ignore;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.UUID;

import static java.lang.String.format;
import static org.junit.Assert.assertTrue;

/**
 * SimpleArrayVsSortedArraySetTest class.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 31.08.2017
 */
public class SimpleArrayVsSortedArraySetTest {
    /**
     * Adding one hundred thousand ordered integers.
     */
    @Test
    public void whenAddOneHundredThousandDifferentIntegersToSetThenCheckTime() {
        final int amount = 100_000;

        SimpleSet<Integer> arraySet = new SimpleArraySet<>();
        Instant start = Instant.now();
        for (int index = 0; index < amount; index++) {
            arraySet.add(Integer.valueOf(index));
        }
        long arraySetDuration = Duration.between(start, Instant.now()).toMillis();

        SimpleSet<Integer> sortedSet = new SimpleSortedSet<>();
        start = Instant.now();
        for (int index = 0; index < amount; index++) {
            sortedSet.add(Integer.valueOf(index));
        }
        long sortedSetDuration = Duration.between(start, Instant.now()).toMillis();
        String message = format("%55s: SimpleSortedSet faster than SimpleArraySet: %d < %d",
                "AddOneHundredThousandDifferentIntegersToSet", sortedSetDuration, arraySetDuration);
        System.out.println(message);
        assertTrue(message, sortedSetDuration < arraySetDuration);
    }

    /**
     * Adding one integer present in set one hundred thousand times.
     */
    @Test
    public void whenAddOneIntegerPresentInSetOneHundredThousandTimesToSetThenCheckTime() {
        final int amount = 100_000;
        final int alreadyAdded = 99_990;

        SimpleSet<Integer> arraySet = new SimpleArraySet<>();
        for (int index = 0; index < amount; index++) {
            arraySet.add(Integer.valueOf(index));
        }
        Instant start = Instant.now();
        for (int index = 0; index < amount; index++) {
            arraySet.add(Integer.valueOf(alreadyAdded));
        }
        long arraySetDuration = Duration.between(start, Instant.now()).toMillis();

        SimpleSet<Integer> sortedSet = new SimpleSortedSet<>();
        for (int index = 0; index < amount; index++) {
            sortedSet.add(Integer.valueOf(index));
        }
        start = Instant.now();
        for (int index = 0; index < amount; index++) {
            sortedSet.add(alreadyAdded);
        }
        long sortedSetDuration = Duration.between(start, Instant.now()).toMillis();

        String message = format("%55s: SimpleSortedSet faster than SimpleArraySet: %d < %d",
                "AddOneIntegerPresentInSetOneHundredThousandTimesToSet", sortedSetDuration, arraySetDuration);
        System.out.println(message);
        assertTrue(message, sortedSetDuration < arraySetDuration);
    }

    /**
     * Adding one hundred thousand random integers.
     */
    @Test
    public void whenAddOneHundredThousandRandomIntegersToSetThenCheckTime() {
        final int amount = 100_000;
        Random rnd = new Random();

        SimpleSet<Integer> arraySet = new SimpleArraySet<>();
        Instant start = Instant.now();
        for (int index = 0; index < amount; index++) {
            arraySet.add(rnd.nextInt());
        }
        long arraySetDuration = Duration.between(start, Instant.now()).toMillis();

        SimpleSet<Integer> sortedSet = new SimpleSortedSet<>();
        start = Instant.now();
        for (int index = 0; index < amount; index++) {
            sortedSet.add(rnd.nextInt());
        }
        long sortedSetDuration = Duration.between(start, Instant.now()).toMillis();
        String message = format("%55s: SimpleSortedSet faster than SimpleArraySet: %d < %d",
                "AddOneHundredThousandRandomIntegersToSet", sortedSetDuration, arraySetDuration);
        System.out.println(message);
        assertTrue(message, sortedSetDuration < arraySetDuration);
    }

    /**
     * Adding one million random integers.
     */
    @Test
    @Ignore
    public void whenAddOneMillionRandomIntegersToSetThenCheckTime() {
        final int amount = 1_000_000;
        Random rnd = new Random();

        SimpleSet<Integer> arraySet = new SimpleArraySet<>();
        Instant start = Instant.now();
        for (int index = 0; index < amount; index++) {
            arraySet.add(rnd.nextInt());
        }
        long arraySetDuration = Duration.between(start, Instant.now()).toMillis();

        SimpleSet<Integer> sortedSet = new SimpleSortedSet<>();
        start = Instant.now();
        for (int index = 0; index < amount; index++) {
            sortedSet.add(rnd.nextInt());
        }
        long sortedSetDuration = Duration.between(start, Instant.now()).toMillis();
        String message = format("%55s: SimpleSortedSet faster than SimpleArraySet: %d < %d",
                "AddOneMillionRandomIntegersToSet", sortedSetDuration, arraySetDuration);
        System.out.println(message);
        assertTrue(message, sortedSetDuration < arraySetDuration);
    }

    /**
     * Adding ten thousand random strings.
     */
    @Test
    public void whenAddTenThousandRandomStringsToSetThenCheckTime() {
        final int amount = 10_000;
        Random rnd = new Random();

        SimpleSet<String> arraySet = new SimpleArraySet<>();
        Instant start = Instant.now();
        for (int index = 0; index < amount; index++) {
            arraySet.add(UUID.randomUUID().toString());
        }
        long arraySetDuration = Duration.between(start, Instant.now()).toMillis();

        SimpleSet<String> sortedSet = new SimpleSortedSet<>();
        start = Instant.now();
        for (int index = 0; index < amount; index++) {
            sortedSet.add(UUID.randomUUID().toString());
        }
        long sortedSetDuration = Duration.between(start, Instant.now()).toMillis();
        String message = format("%55s: SimpleSortedSet faster than SimpleArraySet: %d < %d",
                "AddTenThousandRandomStringsToSet", sortedSetDuration, arraySetDuration);
        System.out.println(message);
        assertTrue(message, sortedSetDuration < arraySetDuration);
    }
}
