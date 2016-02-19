package za.co.bsg.ssd.anagram.acceptance;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import za.co.bsg.ssd.anagram.Main;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * This acceptance test checks that the output produced by the {@link Main} class is exactly what is expected.
 */
public class AnagramCounterAcceptanceIT {

    private OutputStream sysOutContent = new ByteArrayOutputStream();

    @Before
    public void setUpOutputStream() {
        System.setOut(new PrintStream(sysOutContent));
    }

    @After
    public void resetOutputStream() {
        System.setOut(null);
    }

    @Test
    public void testAnagramCalculatorCorrectness() {
        // Exercise SUT
        try {
            Main.main(new String[0]);

            String expectedOutput = "" +
                    "For words '16' characters long there are '   2' anagrams.\n" +
                    "For words '15' characters long there are '   4' anagrams.\n" +
                    "For words '14' characters long there are '  16' anagrams.\n" +
                    "For words '13' characters long there are '  42' anagrams.\n" +
                    "For words '12' characters long there are ' 108' anagrams.\n" +
                    "For words '11' characters long there are ' 213' anagrams.\n" +
                    "For words '10' characters long there are ' 417' anagrams.\n" +
                    "For words ' 9' characters long there are ' 999' anagrams.\n" +
                    "For words ' 8' characters long there are '1929' anagrams.\n" +
                    "For words ' 7' characters long there are '3063' anagrams.\n" +
                    "For words ' 6' characters long there are '3443' anagrams.\n" +
                    "For words ' 5' characters long there are '2766' anagrams.\n" +
                    "For words ' 4' characters long there are '1781' anagrams.\n" +
                    "For words ' 3' characters long there are ' 392' anagrams.\n" +
                    "For words ' 2' characters long there are '  86' anagrams.\n";

            assertThat(sysOutContent.toString(), is(equalTo(expectedOutput)));
        } catch (Throwable throwable) {
            throwable.printStackTrace(System.err);
        }
    }
}
