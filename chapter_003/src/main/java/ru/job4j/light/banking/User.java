package ru.job4j.light.banking;

/**
 * Class User.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 23.08.2017
 */
public class User {
    /**
     * User name.
     */
    private String name;

    /**
     * User passport.
     */
    private String passport;

    /**
     * Construct user.
     *
     * @param name     User name.
     * @param passport User passport.
     */
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     * Equality method.
     *
     * @param o Object under equality test.
     * @return True if objects are equal.
     */
    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (this == o) {
            result = true;
        } else {
            if (o instanceof User) {
                User user = (User) o;
                if (name != null ? name.equals(user.name) : user.name == null) {
                    result = passport != null ? passport.equals(user.passport) : user.passport == null;
                }
            }
        }
        return result;
    }

    /**
     * Calculate hashCode for user.
     *
     * @return HashCode.
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        return result;
    }
}
