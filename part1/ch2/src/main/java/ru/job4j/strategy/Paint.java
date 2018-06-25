package ru.job4j.strategy;

/**
 * Class Paint.
 *
 * @author Vladimir
 * @version 0.1
 * @since 15.08.2017
 */
public class Paint {

    /**
     * Draw shape provided.
     *
     * @param shape Concrete implementation of shape
     */
    public void draw(Shape shape) {
        System.out.println(shape.pic());
    }
}
