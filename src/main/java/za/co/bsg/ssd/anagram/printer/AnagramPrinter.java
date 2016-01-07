package za.co.bsg.ssd.anagram.printer;

import java.util.Map;

/**
 * This interface facilitates the output of the anagram counter's results.
 * For this assignment that should simply be done using {@code System.out}.
 */
public interface AnagramPrinter {

    /**
     * Print the results of the anagram counter.
     * The output should be one pair per line, in descending order of word length.
     *
     * <p>
     *     Follow this format:<br/>
     *     <br/>
     *     For words '10' characters long there are '   2' anagrams.<br/>
     *     For words ' 4' characters long there are '   9' anagrams.<br/>
     *     For words ' 3' characters long there are '  15' anagrams.<br/>
     * </p>
     *
     * @param results The map of word length to number of anagrams.
     */
    void print(Map<Integer, Integer> results);
}
