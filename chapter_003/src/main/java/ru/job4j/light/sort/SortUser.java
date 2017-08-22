package ru.job4j.light.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class SortUser.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 22.08.2017
 */
public class SortUser {
    /**
     * Produce TreeSet from user list.
     *
     * @param list User list.
     * @return User set.
     */
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }
}
