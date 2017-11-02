package ru.job4j.multithreading.threads;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Class WordSpaceCount.
 *
 * @author Vladimir Ivanov
 * @version 0.1
 * @since 22.10.2017
 */
public class WordSpaceCount {
    /**
     * Thread test main.
     *
     * @param args No args here.
     */
    public static void main(String[] args) throws InterruptedException {
        String alice = WordSpaceCount.class.getClassLoader().getResource("alice.txt").getPath();
        WordSpaceCount ws = new WordSpaceCount();
        Thread words = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("word count: " + ws.wordCount(alice));
            }
        });
        Thread spaces = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("space count: " + ws.spaceCount(alice));
            }
        });

        System.out.println("Start programme");
        words.start();
        spaces.start();

        Thread.sleep(1000);

        words.interrupt();
        spaces.interrupt();
        System.out.println("Stop programme");
    }

    /**
     * Count words in a file given.
     *
     * @param filename File name.
     * @return Word count.
     */
    public int wordCount(String filename) {
        int counter = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = br.readLine()) != null) {
                boolean insideWord = false;
                for (char ch : line.toCharArray()) {
                    if (Thread.interrupted()) {
                        System.out.println("word count is interrupted.");
                        return -1;
                    }
                    if (Character.isLetter(ch)) {
                        if (!insideWord) {
                            counter++;
                            insideWord = true;
                        }
                    } else {
                        if (insideWord) {
                            insideWord = false;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return counter;
    }

    /**
     * Count spaces in a file given.
     *
     * @param filename File name.
     * @return Space count.
     */
    public int spaceCount(String filename) {
        int counter = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = br.readLine()) != null) {
                for (char ch : line.toCharArray()) {
                    if (Thread.interrupted()) {
                        System.out.println("space count is interrupted.");
                        return -1;
                    }
                    if (Character.isSpaceChar(ch)) {
                        counter++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return counter;
    }
}
