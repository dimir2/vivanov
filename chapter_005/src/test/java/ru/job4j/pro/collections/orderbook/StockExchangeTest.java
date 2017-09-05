package ru.job4j.pro.collections.orderbook;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static java.lang.String.format;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
    public TemporaryFolder tmp = new TemporaryFolder();

    /**
     * Unzip to tmp directory.
     *
     * @param zip Zipped file.
     */
    private void unzip(String zip) {
        final int BUFFER = 2048;
        try {
            BufferedOutputStream dest = null;
            BufferedInputStream is = null;
            ZipEntry entry;
            ZipFile zipfile = new ZipFile(zip);
            Enumeration e = zipfile.entries();
            while (e.hasMoreElements()) {
                entry = (ZipEntry) e.nextElement();
                is = new BufferedInputStream(zipfile.getInputStream(entry));
                int count;
                byte[] data = new byte[BUFFER];
                FileOutputStream fos = new FileOutputStream(Paths.get(tmp.getRoot().getPath(), entry.getName()).toFile());
                dest = new BufferedOutputStream(fos, BUFFER);
                while ((count = is.read(data, 0, BUFFER)) != -1) {
                    dest.write(data, 0, count);
                }
                dest.flush();
                dest.close();
                is.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test simple order book loading with AddOrder actions and several books.
     */
    @Test
    public void whenLoadTwelveOrdersThenTheyAreLoaded() {
        ClassLoader classLoader = getClass().getClassLoader();
        String file = classLoader.getResource("orders-012.xml").getFile();

        StockExchange exchange = new StockExchange();
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
     * @throws IOException File read exception.
     * @throws URISyntaxException URI conversion exception.
     */
    @Test
    public void whenLoadOneHundredOrdersThenTheyAreLoaded() throws IOException, URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        String file = classLoader.getResource("orders-100.xml").getFile();
        URL out = classLoader.getResource("orders-100.out");
        String expected = new String(Files.readAllBytes(Paths.get(out.toURI())), StandardCharsets.UTF_8);

        StockExchange exchange = new StockExchange();
        exchange.loadOrders(file);
        String result = exchange.toString();

        assertThat(result, is(expected));
    }

    /**
     * Test simple order book loading with Add/Delete actions and several books.
     *
     * @throws IOException File read exception.
     * @throws URISyntaxException URI conversion exception.
     */
    @Test
    public void whenLoadTenThousandOrdersThenTheyAreLoaded() throws IOException, URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        String file = classLoader.getResource("orders-10000.xml").getFile();
        URL out = classLoader.getResource("orders-10000.out");
        String expected = new String(Files.readAllBytes(Paths.get(out.toURI())), StandardCharsets.UTF_8);

        StockExchange exchange = new StockExchange();
        exchange.loadOrders(file);
        String result = exchange.toString();

        assertThat(result, is(expected));
    }

    /**
     * Test original order book. The original file is too big to keep it under GitHub.
     *
     * @throws IOException File read exception.
     * @throws URISyntaxException URI conversion exception.
     */
    @Ignore
    @Test
    public void whenLoadOriginalOrderBookThenItIsLoaded() throws IOException, URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        String file = classLoader.getResource("orders.xml").getFile();
        URL out = classLoader.getResource("orders.out");
        String expected = new String(Files.readAllBytes(Paths.get(out.toURI())), StandardCharsets.UTF_8);

        StockExchange exchange = new StockExchange();
        exchange.loadOrders(file);
        String result = exchange.toString();

        assertThat(result, is(expected));
    }

    /**
     * Test original order book. It needs to be unzipped.
     *
     * @throws IOException File read exception.
     * @throws URISyntaxException URI conversion exception.
     */
    @Test
    public void whenLoadOriginalOrderBookThenItIsLoadedFromZip() throws IOException, URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        unzip(classLoader.getResource("orders.test").getFile());

        String file = Paths.get(tmp.getRoot().getPath(), "orders.xml").toString();

        URL out = classLoader.getResource("orders.out");
        String expected = new String(Files.readAllBytes(Paths.get(out.toURI())), StandardCharsets.UTF_8);

        StockExchange exchange = new StockExchange();
        exchange.loadOrders(file);
        String result = exchange.toString();

        assertThat(result, is(expected));
    }
}