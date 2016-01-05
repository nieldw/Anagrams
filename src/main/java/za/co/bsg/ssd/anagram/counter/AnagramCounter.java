package za.co.bsg.ssd.anagram.counter;

import java.util.List;
import java.util.Map;

/**
 * The business logic for counting anagrams.
 */
public interface AnagramCounter {

    /**
     * Count the number of anagrams for each length of word.
     * <p>
     * For example:
     * Given the {@code words} "friend", "refind", "finder", "monster", "mentors", and "two",
     * the result should be { 6 = 3, 7 = 2 }.
     * </p>
     *
     * <p>
     *     If there are no anagrams for a particular length of word, like "two" in the
     *     above example, no entry should be returned for it.
     * </p>
     *
     * @param words The list of words in which to find anagrams.
     * @return A map of word length (key) to number of anagrams with that length (value).
     */
    Map<Integer, Integer> countAnagramsPerWordLength(List<String> words);
}
