package ru.job4j.profession;

/**
 * Class Profession.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 09.08.2017
 */
abstract class Profession {

    /**
     * Person name.
     */
    private String name;

    /**
     * Profession title.
     */
    private String profession;

    /**
     * Constructor.
     *
     * @param name Person name.
     */
    Profession(String name) {
        this.name = name;
    }

    /**
     * Getter for person name.
     *
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for profession title.
     *
     * @return Name
     */
    public String getProfession() {
        return profession;
    }

    /**
     * Setter for profession title.
     *
     * @param profession Profession title
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }
}