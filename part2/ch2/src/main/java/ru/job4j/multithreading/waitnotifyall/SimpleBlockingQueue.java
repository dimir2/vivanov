package ru.job4j.multithreading.waitnotifyall;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * SimpleBlockingQueue class.
 *
 * @param <T> Any object.
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 02.07.2018
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {
    private static final int DEFAULT_MAX_COUNT = 10;
    private int maxCount;
    private int count = 0;

    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();

    public SimpleBlockingQueue(int maxCount) {
        this.maxCount = maxCount;
    }

    public SimpleBlockingQueue() {
        this(DEFAULT_MAX_COUNT);
    }

    /**
     * Offer new value to queue (put?).
     * @param value - Value.
     */
    synchronized public void offer(T value) {
        while (count == maxCount) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (count < maxCount) {
            queue.offer(value);
            count++;
            this.notify();
        }
    }

    /**
     * Poll available value from the queue
     * @return
     */
    synchronized public T poll() {
        T value = null;
        while (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (count > 0) {
            count--;
            value = queue.poll();
            this.notify();
        }
        return value;
    }
}

