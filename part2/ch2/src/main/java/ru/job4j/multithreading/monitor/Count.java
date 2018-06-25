package ru.job4j.multithreading.monitor;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Class Count.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 25.12.2017
 */
@ThreadSafe
public class Count {
    /**
     * Internal counter storage.
     */
    @GuardedBy("this")
    private int value;

    /**
     * Increments counter by one.
     */
    public synchronized void increment() {
        this.value++;
    }

    /**
     * Getter for the counter.
     *
     * @return Value.
     */
    public synchronized int get() {
        return this.value;
    }
}
