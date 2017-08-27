package ru.job4j.pro.collections;

/**
 * Class Base.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 27.08.2017
 */
public abstract class Base {
    /**
     * id.
     */
    private String id;

    /**
     * Construct Base object.
     *
     * @param id id.
     */
    public Base(String id) {
        this.id = id;
    }

    /**
     * Get element id.
     *
     * @return Element id.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Set element id.
     *
     * @param id Element id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj
     * argument; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (this == obj) {
            result = true;
        } else {
            if (obj instanceof Base) {
                Base base = (Base) obj;
                result = (id != null) ? id.equals(base.id) : base.id == null;
            }
        }
        return result;
    }
}
