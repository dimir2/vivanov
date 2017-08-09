package ru.job4j.profession;

/**
 * Class Teacher.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 09.08.2017
 */
public class Teacher extends Profession {

    /**
     * Constructor.
     * @param name Teacher name
     */
    public Teacher(String name) {
        super(name);
        setProfession("Teacher");
    }

    /**
     * Common activity of Teacher.
     * @param student {@link Student} to teach
     * @return String with teacher's activity description
     */
    public String teach(Profession student) {
        return String.format("%s %s teaches %s %s well!", getProfession(), getName(), student.getProfession(), student.getName());
    }
}
