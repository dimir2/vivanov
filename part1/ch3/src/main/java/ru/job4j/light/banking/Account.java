package ru.job4j.light.banking;

/**
 * Class Account.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 23.08.2017
 */
public class Account {
    /**
     * Account requisites.
     */
    private final String requisites;
    /**
     * Account value.
     */
    private double value;

    /**
     * Constructs user account.
     *
     * @param requisites Account requisites.
     * @param value      Account value.
     */
    public Account(String requisites, double value) {
        this.requisites = requisites;
        this.value = ((int) (value * 100d)) / 100d;
    }

    /**
     * Constructs user account.
     *
     * @param requisites Account requisites.
     */
    public Account(String requisites) {
        this(requisites, 0d);
    }

    /**
     * Account equality method.
     *
     * @param o Object to test.
     * @return True if accounts equal.
     */
    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (this == o) {
            result = true;
        } else {
            if (o != null && getClass() == o.getClass()) {
                Account account = (Account) o;
                result = requisites != null ? requisites.equals(account.requisites) : account.requisites == null;
            }
        }
        return result;
    }

    /**
     * Calculate hashCode for the account object.
     *
     * @return HashCode.
     */
    @Override
    public int hashCode() {
        return requisites != null ? requisites.hashCode() : 0;
    }

    /**
     * Value getter.
     *
     * @return Account value.
     */
    public double getValue() {
        return value;
    }

    /**
     * Value setter.
     *
     * @param value Account value.
     */
    public void setValue(double value) {
        this.value = ((int) (value * 100d)) / 100d;
    }

    /**
     * Requisites getter.
     *
     * @return Account requisites
     */
    public String getRequisites() {
        return requisites;
    }
}
