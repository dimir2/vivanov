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
    public static void main(String[] args) {
        String alice = WordSpaceCount.class.getClassLoader().getResource("alice.txt").getPath();
        WordSpaceCount ws = new WordSpaceCount();
        Runnable words = new Runnable() {
            @Override
            public void run() {
                System.out.println("word count: " + ws.wordCount(alice));
            }
        };
        Runnable spaces = new Runnable() {
            @Override
            public void run() {
                System.out.println("space count: " + ws.spaceCount(alice));
            }
        };
        new Thread(words).start();
        new Thread(spaces).start();
    }

    /**
     * Count words in a file given.
     *
     * @param fname File name.
     * @return Word count.
     */
    public int wordCount(String fname) {
        int counter = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fname));
            String line;

            while ((line = br.readLine()) != null) {
                boolean insideWord = false;
                for (char ch : line.toCharArray()) {
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
     * @param fname File name.
     * @return Space count.
     */
    public int spaceCount(String fname) {
        int counter = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fname));
            String line;

            while ((line = br.readLine()) != null) {
                for (char ch : line.toCharArray()) {
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
