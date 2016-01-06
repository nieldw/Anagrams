package za.co.bsg.ssd.anagram.printer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.inOrder;

@RunWith(MockitoJUnitRunner.class)
public class PrintStreamAnagramPrinterTest {

    @Mock
    private PrintStream printStream;

    @Test
    public void print_shouldPrintInCorrectFormatAndOrder() throws Exception {
        // Set up fixture
        PrintStreamAnagramPrinter printer = new PrintStreamAnagramPrinter(printStream);

        // Exercise SUT
        Map<Integer, Integer> anagramCounts = new HashMap<>();
        anagramCounts.put(10, 2);
        anagramCounts.put(3, 14);
        anagramCounts.put(13, 4);

        printer.print(anagramCounts);

        // Verify behaviour
        InOrder inOrder = inOrder(printStream);
        inOrder.verify(printStream).println("For words '13' characters long there are ' 4' anagrams.");
        inOrder.verify(printStream).println("For words '10' characters long there are ' 2' anagrams.");
        inOrder.verify(printStream).println("For words ' 3' characters long there are '14' anagrams.");
    }
}