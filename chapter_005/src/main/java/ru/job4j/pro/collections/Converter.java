package ru.job4j.pro.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class Converter.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 25.08.2017
 */
public class Converter {
    /**
     * Convert Iterator<Iterator<Integer>> into Iterator<Integer>.
     *
     * @param it Iterator on Iterators of Integers.
     * @return Iterator on Integers.
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            /**
             * Current iterator of iterators.
             */
            private Iterator<Integer> current = (!it.hasNext()) ? null : it.next();

            /**
             * hasNext() implementation.
             *
             * @return True if next element exists.
             */
            @Override
            public boolean hasNext() {
                boolean result = false;
                while (this.current != null) {
                    if (!this.current.hasNext()) {
                        this.current = (it.hasNext()) ? it.next() : null;
                    } else {
                        result = true;
                        break;
                    }
                }
                return result;
            }

            /**
             * next() implementation.
             *
             * @return next Integer.
             */
            @Override
            public Integer next() throws NoSuchElementException {
                if (!this.hasNext()) {
                    throw new NoSuchElementException("No elements left");
                }
                return this.current.next();
            }

        };
    }
}
