package ru.job4j.profession;

/**
 * Class Doctor.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 09.08.2017
 */
public class Doctor extends Profession {

    /**
     * Constructor.
     *
     * @param name Doctor name
     */
    public Doctor(String name) {
        super(name);
        setProfession("Doctor");
    }

    /**
     * Common activity of Doctor.
     *
     * @param patient {@link Patient} to heal
     * @return String with Doctor's activity description
     */
    public String heal(Profession patient) {
        return String.format("%s %s heals %s %s well!", getProfession(), getName(), patient.getProfession(), patient.getName());
    }
}
