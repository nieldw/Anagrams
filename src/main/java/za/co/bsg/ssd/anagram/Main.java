package za.co.bsg.ssd.anagram;

import za.co.bsg.ssd.anagram.counter.AnagramCounter;
import za.co.bsg.ssd.anagram.counter.PrimeFactorAnagramCounter;
import za.co.bsg.ssd.anagram.counter.SortingAnagramCounter;
import za.co.bsg.ssd.anagram.printer.AnagramPrinter;
import za.co.bsg.ssd.anagram.printer.PrintStreamAnagramPrinter;
import za.co.bsg.ssd.anagram.reader.UrlDictionaryWordList;
import za.co.bsg.ssd.anagram.reader.WordList;

import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        if (args.length > 1) {
            System.out.println("Add only one argument to use the SortingAnagramCounter " +
                    "instead of the PrimeFactorAnagramCounter");
            return;
        }

        URL dictionary = Main.class.getResource("/british-english.txt");
        WordList wordList = new UrlDictionaryWordList(dictionary, StandardCharsets.UTF_8);
        AnagramPrinter anagramPrinter = new PrintStreamAnagramPrinter(System.out);
        AnagramCounter anagramCounter = args.length == 0 ? new PrimeFactorAnagramCounter() : new SortingAnagramCounter();

        AnagramCalculator anagramCalculator = new AnagramCalculator(wordList, anagramCounter, anagramPrinter);
        anagramCalculator.run();
    }
}
