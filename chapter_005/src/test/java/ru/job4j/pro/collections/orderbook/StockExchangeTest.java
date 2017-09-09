package ru.job4j.pro.collections.orderbook;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import ru.job4j.pro.collections.orderbook.loader.ManualLoader;
import ru.job4j.pro.collections.orderbook.loader.StAXLoader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;

import static java.lang.String.format;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static ru.job4j.testutils.UnZip.unzip;

/**
 * Class StockExchangeTest.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 06.09.2017
 */
public class StockExchangeTest {
    /**
     * Temporary dir for these tests. Cleared after test.
     */
    @Rule
    public TemporaryFolder tmpDir = new TemporaryFolder();

    /**
     * Unpack all resources into the tmpDir folder.
     */
    @Before
    public void unpackAllResourcesBeforeTests() {
        ClassLoader classLoader = getClass().getClassLoader();
        unzip(classLoader.getResource("orders.xml.zipped").getFile(), tmpDir);
        unzip(classLoader.getResource("orders-10000.xml.zipped").getFile(), tmpDir);
    }

    /**
     * Test simple order book loading with AddOrder actions and several books.
     */
    @Test
    public void whenLoadTwelveOrdersThenTheyAreLoaded() {
        ClassLoader classLoader = getClass().getClassLoader();
        String file = classLoader.getResource("orders-012.xml").getFile();

        StockExchange exchange = new StockExchange(StAXLoader.getInstance());
        exchange.loadOrders(file);

        String result = exchange.toString();

        StringBuilder expected = new StringBuilder();
        expected.append(format("%n          Order book: book-1%n"));
        expected.append(format("%n         BID         -         ASK%n"));
        expected.append(format("     99.80@64        -    100.50@81        %n"));
        expected.append(format("     99.70@16        -         ---%n"));
        expected.append(format("%n          Order book: book-2%n"));
        expected.append(format("%n         BID         -         ASK%n"));
        expected.append(format("     99.40@78        -    100.20@42        %n"));
        expected.append(format("         ---         -    100.50@125       %n"));
        expected.append(format("%n          Order book: book-3%n"));
        expected.append(format("%n         BID         -         ASK%n"));
        expected.append(format("     99.50@86        -    100.00@210       %n"));
        expected.append(format("         ---         -    100.40@75        %n"));

        assertThat(result, is(expected.toString()));
    }

    /**
     * Test simple order book loading with Add/Delete actions and several books.
     *
     * @throws IOException        File read exception.
     * @throws URISyntaxException URI conversion exception.
     */
    @Test
    public void whenLoadOneHundredOrdersThenTheyAreLoaded() throws IOException, URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        String file = classLoader.getResource("orders-100.xml").getFile();
        URL out = classLoader.getResource("orders-100.out");
        String expected = new String(Files.readAllBytes(Paths.get(out.toURI())), StandardCharsets.UTF_8);

        StockExchange exchange = new StockExchange(StAXLoader.getInstance());
        exchange.loadOrders(file);
        String result = exchange.toString();

        assertThat(result, is(expected));
    }

    /**
     * Test simple order book loading with Add/Delete actions and several books.
     *
     * @throws IOException        File read exception.
     * @throws URISyntaxException URI conversion exception.
     */
    @Test
    public void whenLoadTenThousandOrdersThenTheyAreLoaded() throws IOException, URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        String file = Paths.get(tmpDir.getRoot().getPath(), "orders-10000.xml").toString();

        URL out = classLoader.getResource("orders-10000.out");
        String expected = new String(Files.readAllBytes(Paths.get(out.toURI())), StandardCharsets.UTF_8);

        StockExchange exchange = new StockExchange(StAXLoader.getInstance());
        exchange.loadOrders(file);
        String result = exchange.toString();

        assertThat(result, is(expected));
    }

    /**
     * Test original order book..
     *
     * @throws IOException        File read exception.
     * @throws URISyntaxException URI conversion exception.
     */
    @Test
    public void whenLoadOriginalOrderBookThenItIsLoaded() throws IOException, URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        String file = Paths.get(tmpDir.getRoot().getPath(), "orders.xml").toString();

        URL out = classLoader.getResource("orders.out");
        String expected = new String(Files.readAllBytes(Paths.get(out.toURI())), StandardCharsets.UTF_8);

        StockExchange exchange = new StockExchange(StAXLoader.getInstance());
        exchange.loadOrders(file);
        String result = exchange.toString();

        assertThat(result, is(expected));
    }

    /**
     * Test original order book load time with StAXLoader.
     *
     * @throws IOException        File read exception.
     * @throws URISyntaxException URI conversion exception.
     */
    @Test
    public void whenLoadOriginalOrderBookWithStAXLoaderThenItTakesMoreThanSixSeconds() throws IOException, URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        String file = Paths.get(tmpDir.getRoot().getPath(), "orders.xml").toString();

        long expected = 6000L;
        Instant start = Instant.now();

        StockExchange exchange = new StockExchange(StAXLoader.getInstance());
        exchange.loadOrders(file);
        exchange.toString();

        long result = Duration.between(start, Instant.now()).toMillis();
        System.out.println(format("%20s: Duration is %d millis", "StAXLoader", result));

        assertTrue(result > expected);
    }

    /**
     * Test original order book load time with ManualLoader.
     *
     * @throws IOException        File read exception.
     * @throws URISyntaxException URI conversion exception.
     */
    @Test
    public void whenLoadOriginalOrderBookWithManualLoaderThenItTakesLessThanSixSeconds() throws IOException, URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        String file = Paths.get(tmpDir.getRoot().getPath(), "orders.xml").toString();

        long expected = 6000L;
        Instant start = Instant.now();

        StockExchange exchange = new StockExchange(ManualLoader.getInstance());
        exchange.loadOrders(file);
        exchange.toString();

        long result = Duration.between(start, Instant.now()).toMillis();
        System.out.println(format("%20s: Duration is %d millis", "ManualLoader", result));

        assertTrue(result < expected);
    }
}