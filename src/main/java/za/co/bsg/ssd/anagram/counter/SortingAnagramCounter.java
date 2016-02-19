package za.co.bsg.ssd.anagram.counter;

import java.util.*;

/**
 * This is a naive implementation of {@link AnagramCounter}, which simply sorts the characters of a word to determine
 * whether it is an anagram of another word. This implementation is provided as a control to compare with the results
 * of the {@link PrimeFactorAnagramCounter}.
 */
public class SortingAnagramCounter implements AnagramCounter {
    @Override
    public Map<Integer, Integer> countAnagramsPerWordLength(List<String> words) {
        Set<String> uniqueLowercaseWords = new HashSet<>(words.size());
        for (String word : words) {
            uniqueLowercaseWords.add(word.toLowerCase());
        }

        Map<String, Integer> anagramCount = new HashMap<>();
        for (String word : uniqueLowercaseWords) {
            if (word.length() < 2) {
                continue;
            }
            String sortedWord = getSortedString(word);
            anagramCount.put(sortedWord, anagramCount.getOrDefault(sortedWord, 0) + 1);
        }

        Map<Integer, Integer> anagramLengthCount = new HashMap<>();
        for (Map.Entry<String, Integer> entry : anagramCount.entrySet()) {
            if (entry.getValue() < 2) {
                continue;
            }
            int length = entry.getKey().length();
            anagramLengthCount.put(length, anagramLengthCount.getOrDefault(length, 0) + entry.getValue());
        }

        return anagramLengthCount;
    }

    private String getSortedString(String word) {
        char[] chars = word.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
