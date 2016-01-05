package za.co.bsg.ssd.anagram;

import za.co.bsg.ssd.anagram.counter.AnagramCounter;
import za.co.bsg.ssd.anagram.printer.AnagramPrinter;
import za.co.bsg.ssd.anagram.reader.WordList;

import java.util.List;
import java.util.Map;

/**
 * This is the main class orchestrating the calculation of anagrams.
 */
public class AnagramCalculator {

    private final WordList wordList;
    private final AnagramCounter anagramCounter;
    private final AnagramPrinter anagramPrinter;

    public AnagramCalculator(WordList wordList, AnagramCounter anagramCounter, AnagramPrinter anagramPrinter) {
        this.wordList = wordList;
        this.anagramCounter = anagramCounter;
        this.anagramPrinter = anagramPrinter;
    }

    public void run() {
        List<String> words = wordList.readAll();
        Map<Integer, Integer> anagramsPerWordLength = anagramCounter.countAnagramsPerWordLength(words);
        anagramPrinter.print(anagramsPerWordLength);
    }
}
