package ru.job4j.pro.collections.orderbook.loader;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import static java.lang.String.format;

/**
 * Class DeleteOrder.
 *
 * @author Vladimir Ivanov
 * @version 0.2
 * @since 06.09.2017
 */
@XmlRootElement(name = "DeleteOrder")
public class DeleteOrder extends Order {
    /**
     * Constructs order.
     *
     * @param book    Order book.
     * @param orderId Order id.
     */
    public DeleteOrder(String book, int orderId) {
        super(book, null, 0, 0, orderId);
    }

    /**
     * Default non-arg constructor is required.
     */
    public DeleteOrder() {
        super();
    }

    /**
     * Set order book.
     *
     * @param book Order book.
     */
    @XmlAttribute(name = "book")
    public void setBook(String book) {
        this.book = book;
    }

    /**
     * Set order id.
     *
     * @param orderId Order id.
     */
    @XmlAttribute(name = "orderId")
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * String representation of order.
     *
     * @return String.
     */
    @Override
    public String toString() {
        return format("DeleteOrder {book='%s', orderId=%d}", book, orderId);
    }
}
