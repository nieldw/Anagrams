package za.co.bsg.ssd.anagram.printer;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class PrintStreamAnagramPrinter implements AnagramPrinter {

    private PrintStream printStream;

    public PrintStreamAnagramPrinter(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void print(Map<Integer, Integer> results) {
        TreeMap<Integer, Integer> orderedResultsMap = new TreeMap<>(Comparator.reverseOrder());
        orderedResultsMap.putAll(results);

        orderedResultsMap.forEach((length, anagrams) -> printStream.println(
                String.format("For words '%2d' characters long there are '%2d' anagrams.", length, anagrams)));
    }
}
