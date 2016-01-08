package za.co.bsg.ssd.anagram.counter;

import org.junit.Test;

public class PrimeFactorAnagramCounterTest {

    private TestAnagramCounter tester = new TestAnagramCounter();

    @Test
    public void countAnagramsPerWordLength() throws Exception {
        AnagramCounter anagramCounter = new PrimeFactorAnagramCounter();
        tester.testCountAnagramsPerWordLength(anagramCounter);
    }
}