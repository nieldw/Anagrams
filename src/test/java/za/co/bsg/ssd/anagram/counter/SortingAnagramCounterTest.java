package za.co.bsg.ssd.anagram.counter;

import org.junit.Test;

public class SortingAnagramCounterTest {

    private TestAnagramCounter tester = new TestAnagramCounter();

    @Test
    public void countAnagramsPerWordLength() throws Exception {
        AnagramCounter anagramCounter = new SortingAnagramCounter();
        tester.testCountAnagramsPerWordLength(anagramCounter);
    }
}