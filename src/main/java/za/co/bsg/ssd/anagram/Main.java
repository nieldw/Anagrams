package za.co.bsg.ssd.anagram;

import za.co.bsg.ssd.anagram.reader.UrlDictionaryWordList;
import za.co.bsg.ssd.anagram.reader.WordList;

import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        /**
         * Provide implementations for {@link za.co.bsg.ssd.anagram.reader.WordList},
         * {@link za.co.bsg.ssd.anagram.counter.AnagramCounter}, and
         * {@link za.co.bsg.ssd.anagram.printer.AnagramPrinter}. Then replace the nulls in the instantiation
         * below with your implementations.
         */
        URL dictionary = Main.class.getResource("/british-english.txt");
        WordList wordList = new UrlDictionaryWordList(dictionary, StandardCharsets.UTF_8);

        AnagramCalculator anagramCalculator = new AnagramCalculator(wordList, null, null);

        try {
            anagramCalculator.run();
        } catch (NullPointerException e) {
            System.err.println("Did you forget to provide your implementations to the AnagramCalculator?");
            throw e;
        }
    }
}
