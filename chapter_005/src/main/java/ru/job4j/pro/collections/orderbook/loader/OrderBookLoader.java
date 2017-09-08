package ru.job4j.pro.collections.orderbook.loader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import java.io.FileInputStream;
import java.util.TreeSet;

/**
 * Class OrderBookLoader.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 06.09.2017
 */
public class OrderBookLoader {
    /**
     * Constructs OrderBookLoader.
     */
    public OrderBookLoader() {
    }

    /**
     * The other way to create an instance.
     *
     * @return OrderBookLoader object.
     */
    public static OrderBookLoader getInstance() {
        return new OrderBookLoader();
    }

    /**
     * Loads orders set from file.
     *
     * @param file XML file with orders.
     * @return Orders set.
     */
    public TreeSet<Order> load(String file) {
        TreeSet<Order> orders = new TreeSet<>();
        try {
            XMLInputFactory xif = XMLInputFactory.newFactory();
            XMLEventReader xer = xif.createXMLEventReader(new FileInputStream(file));
            Unmarshaller addOrder = JAXBContext.newInstance(AddOrder.class).createUnmarshaller();
            Unmarshaller delOrder = JAXBContext.newInstance(DeleteOrder.class).createUnmarshaller();

            while (xer.hasNext()) {
                if (xer.peek().isStartElement()) {
                    String element = xer.peek().asStartElement().getName().getLocalPart();
                    if (element.equals("AddOrder")) {
                        AddOrder order = (AddOrder) addOrder.unmarshal(xer);
                        orders.add(order);
                    } else if (element.equals("DeleteOrder")) {
                        DeleteOrder order = (DeleteOrder) delOrder.unmarshal(xer);
                        orders.remove(order);
                    }
                }
                if (xer.hasNext()) {
                    xer.nextEvent();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }
}