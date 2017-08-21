package ru.job4j.light;

import java.util.HashMap;
import java.util.List;

/**
 * Class UserConvert.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 21.08.2017
 */
public class UserConvert {
    /**
     * Process user list and generate HashMap by user id as key.
     *
     * @param list User list.
     * @return HashMap produced.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<>();
        for (User user : list) {
            map.put(user.id, user);
        }
        return map;
    }
}
