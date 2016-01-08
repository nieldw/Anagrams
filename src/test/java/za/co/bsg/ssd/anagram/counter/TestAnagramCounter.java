package za.co.bsg.ssd.anagram.counter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestAnagramCounter {
    void testCountAnagramsPerWordLength(AnagramCounter anagramCounter) {
        // Set up fixture
        List<String> wordList = asList(
                "Harmonicas", "Maraschino",
                "friend", "finder", "barely", "barley", "bleary",
                "monster", "mentors",
                "two",
                "dry",
                "W", "w");

        Map<Integer, Integer> expectedResult = new HashMap<>();
        expectedResult.put(6, 5);
        expectedResult.put(7, 2);
        expectedResult.put(10, 2);

        // Exercise SUT
        Map<Integer, Integer> actualResult = anagramCounter.countAnagramsPerWordLength(wordList);

        // Verify behaviour
        assertThat(actualResult, equalTo(expectedResult));
    }
}
