package ru.job4j.light.sort;

import java.util.Comparator;
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

    /**
     * Sort user list by name length.
     *
     * @return Sorted user list.
     */
    public List<User> sortByNameLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.name.length(), o2.name.length());
            }
        });
        return list;
    }

    /**
     * Sort user list by all fields.
     *
     * @return Sorted user list.
     */
    public List<User> sortByAllFields(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result = o1.name.compareTo(o2.name);
                if (result == 0) {
                    result = Integer.compare(o1.age, o2.age);
                }
                return result;
            }
        });
        return list;
    }
}
