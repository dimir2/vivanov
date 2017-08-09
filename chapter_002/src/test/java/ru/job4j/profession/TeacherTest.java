package ru.job4j.profession;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class TeacherTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 09.08.2017
 */
public class TeacherTest {

    /**
     * Teach Test.
     */
    @Test
    public void whenTeacherTeachesStudentThenHeTeachesWell() {
        Profession teacher = new Teacher("Alexey");
        Profession student = new Student("Dmitry");
        String result = ((Teacher) teacher).teach(student);
        String expected = "Teacher Alexey teaches student Dmitry well!";
        assertThat(result, is(expected));
    }
}