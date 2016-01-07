package za.co.bsg.ssd.anagram.counter;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

/**
 * This {@link AnagramCounter} relies on the unique-prime-factorization theorem, also known as the fundamental theorem
 * of arithmetic, and on the commutative property of multiplication, by assigning a prime number to each character
 * encountered. The product of the prime numbers is unique, and due to the commutative property anagrams have the same
 * product.
 */
public class PrimeFactorAnagramCounter implements AnagramCounter {
    @Override
    public Map<Integer, Integer> countAnagramsPerWordLength(List<String> words) {
        PrimeNumberMap primeNumberMap = new PrimeNumberMap();

        return words.stream()
                .filter(word -> word.length() > 1)
                .map(word -> new Word(word.toLowerCase(), primeNumberMap))
                .collect(groupingBy(anagram -> anagram, counting()))

                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(groupingBy(entry -> entry.getKey().getLength(), summingInt(entry -> entry.getValue().intValue())));
    }
}
