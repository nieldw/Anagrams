package za.co.bsg.ssd.anagram;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import za.co.bsg.ssd.anagram.counter.AnagramCounter;
import za.co.bsg.ssd.anagram.printer.AnagramPrinter;
import za.co.bsg.ssd.anagram.reader.WordList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AnagramCalculatorTest {

    @Mock
    private WordList wordList;
    @Mock
    private AnagramCounter anagramCounter;
    @Mock
    private AnagramPrinter anagramPrinter;

    private AnagramCalculator anagramCalculator;

    @Test
    public void run_shouldReadCalculatePrint() {
        // Set up fixture
        List<String> words = asList("Aardvark", "Avocado");
        Map<Integer, Integer> results = new HashMap<>();

        anagramCalculator = new AnagramCalculator(wordList, anagramCounter, anagramPrinter);

        // Set expectations
        when(wordList.readAll()).thenReturn(words);
        when(anagramCounter.countAnagramsPerWordLength(words)).thenReturn(results);

        // Exercise SUT
        anagramCalculator.run();

        // Verify behaviour
        verify(wordList).readAll();
        verify(anagramCounter).countAnagramsPerWordLength(words);
        verify(anagramPrinter).print(results);
    }
}