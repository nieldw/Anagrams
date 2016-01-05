package za.co.bsg.ssd.anagram.reader;

import java.util.List;

/**
 * This interface provides all the words among which to find anagrams.
 */
public interface WordList {

    /**
     * @return All the words in the list.
     */
    List<String> readAll();
}
