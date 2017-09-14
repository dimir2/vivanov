package ru.job4j.pro.collections.orderbook.tdd;

import java.util.*;

/**
 * Class Book.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 13.09.2017
 */
public class Book {
    /**
     * Book name.
     */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public final String name;

    /**
     * Ask orders set.
     */
    private final TreeSet<MatchOrder> askSet;
    /**
     * Ask orders set.
     */
    private final TreeSet<MatchOrder> bidSet;


    /**
     * Creates book.
     *
     * @param name Book name.
     */
    public Book(String name) {
        this.name = name;
        this.askSet = new TreeSet<>(new Comparator<MatchOrder>() {
            @Override
            public int compare(MatchOrder o1, MatchOrder o2) {
                return o1.compareTo(o2);
            }
        });
        this.bidSet = new TreeSet<>(new Comparator<MatchOrder>() {
            @Override
            public int compare(MatchOrder o1, MatchOrder o2) {
                return o2.compareTo(o1);
            }
        });
    }

    /**
     * Adds order to book.
     *
     * @param order Order.
     * @return True if added.
     */
    public boolean add(Order order) {
        return this.add((order.op.equals(Order.Op.BUY) ? bidSet : askSet), new MatchOrder(order.price, order.value));
    }

    private boolean add(TreeSet<MatchOrder> set, MatchOrder match) {
        boolean result = true;

        if (op.equals(Order.Op.BUY)) {
            if (!matchAsk(match)) {
                result = addBid(match);
            }
        } else {
            if (!matchBid(match)) {
                result = addAsk(match);
            }
        }
        return result;
    }

    private boolean addAsk(MatchOrder match) {
        boolean result = true;
        if (this.askSet.contains(match)) {
            MatchOrder found = this.askSet.ceiling(match);
            found.shiftValue(match.value());
        } else {
            result = this.askSet.add(match);
        }
        return result;
    }

    private boolean addBid(MatchOrder match) {
        boolean result = true;
        if (this.bidSet.contains(match)) {
            MatchOrder found = this.bidSet.ceiling(match);
            found.shiftValue(match.value());
        } else {
            result = this.bidSet.add(match);
        }
        return result;
    }

    private boolean matchAsk(MatchOrder bid) {
        boolean result = false;
        Iterator<MatchOrder> it = this.askSet.iterator();
        while (it.hasNext()) {
            MatchOrder ask = it.next();
            if (ask.price() <= bid.price()) {
                if (ask.value() > bid.value()) {
                    ask.shiftValue(-bid.value());
                } else if (ask.value() <= bid.value()) {
                    bid.shiftValue(-ask.value());
                    this.askSet.remove(ask);
                    if (ask.value() < bid.value()) {

                    }
                }
            }
            break;
        }
        return result;
    }

    private boolean matchBid(MatchOrder match) {
        boolean result = true;

        return result;
    }

    public List<MatchOrder> asAskList() {
        return new ArrayList<>(this.askSet);
    }

    public List<MatchOrder> asBidList() {
        return new ArrayList<>(this.bidSet);
    }
}
