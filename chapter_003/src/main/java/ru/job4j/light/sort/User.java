package ru.job4j.light.sort;

/**
 * Class User.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 22.08.2017
 */
public class User implements Comparable<User> {
    /**
     * User name.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public final String name;
    /**
     * User age.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public final Integer age;

    /**
     * Construct a user.
     *
     * @param name User name.
     * @param age  User age.
     */
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Compare two User objects.
     *
     * @param o User object to compare.
     * @return -1, 0, 1
     */
    @Override
    public int compareTo(User o) {
        int result = this.age.compareTo(o.age);
        if (result == 0) {
            result = this.name.compareTo(o.name);
        }
        return result;
    }

    /**
     * Auto generated equals.
     *
     * @param o Object to compare
     * @return Equality test result
     */
    @Override
    public boolean equals(Object o) {
        boolean result = true;
        if (this != o) {
            if (!(o instanceof User)) {
                result = false;
            } else {
                User user = (User) o;
                result = (name != null) ? name.equals(user.name) : user.name == null;
                if (result) {
                    result = (age != null) ? age.equals(user.age) : user.age == null;
                }
            }
        }
        return result;
    }

    /**
     * Auto generated hashCode.
     *
     * @return Equality test result
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }
}

