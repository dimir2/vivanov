package ru.job4j.pro.collections.orderbook.loader;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import static java.lang.String.format;

/**
 * Class AddOrder.
 *
 * @author Vladimir Ivanov
 * @version 0.2
 * @since 06.09.2017
 */
@XmlRootElement(name = "AddOrder")
public class AddOrder extends Order {
    /**
     * Constructs order.
     *
     * @param book      Order book.
     * @param operation Order operation.
     * @param price     Order price.
     * @param volume    Order volume.
     * @param orderId   Order id.
     */
    public AddOrder(String book, String operation, float price, int volume, int orderId) {
        super(book, operation, price, volume, orderId);
    }

    /**
     * No-arg default constructor is required.
     */
    public AddOrder() {
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
     * Set order operation.
     *
     * @param operation Order operation.
     */
    @XmlAttribute(name = "operation")
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * Set order price.
     *
     * @param price Order price.
     */
    @XmlAttribute(name = "price")
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Set order volume.
     *
     * @param volume Order volume.
     */
    @XmlAttribute(name = "volume")
    public void setVolume(int volume) {
        this.volume = volume;
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
        return format("AddOrder {book='%s', operation=%s, price=%.2f, volume=%d, orderId=%d}", book, operation, price, volume, orderId);
    }
}
