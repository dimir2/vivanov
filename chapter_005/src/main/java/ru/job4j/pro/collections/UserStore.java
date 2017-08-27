package ru.job4j.pro.collections;

/**
 * Class UserStore.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 27.08.2017
 */
public class UserStore extends AbstractStore<User> {
    /**
     * Construct Store.
     *
     * @param capacity Storage capacity.
     */
    public UserStore(int capacity) {
        super(capacity);
    }
}
