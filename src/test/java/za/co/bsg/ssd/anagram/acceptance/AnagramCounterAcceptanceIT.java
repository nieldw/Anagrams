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

    private static final String EXPECTED_OUTPUT = "" +
            "For words '16' characters long there are '   2' anagrams.\n" +
            "For words '15' characters long there are '   2' anagrams.\n" +
            "For words '14' characters long there are '  10' anagrams.\n" +
            "For words '13' characters long there are '  18' anagrams.\n" +
            "For words '12' characters long there are '  72' anagrams.\n" +
            "For words '11' characters long there are ' 133' anagrams.\n" +
            "For words '10' characters long there are ' 313' anagrams.\n" +
            "For words ' 9' characters long there are ' 804' anagrams.\n" +
            "For words ' 8' characters long there are '1610' anagrams.\n" +
            "For words ' 7' characters long there are '2662' anagrams.\n" +
            "For words ' 6' characters long there are '2971' anagrams.\n" +
            "For words ' 5' characters long there are '2370' anagrams.\n" +
            "For words ' 4' characters long there are '1459' anagrams.\n" +
            "For words ' 3' characters long there are ' 294' anagrams.\n" +
            "For words ' 2' characters long there are '  66' anagrams.\n";

    @Before
    public void setUpOutputStream() {
        System.setOut(new PrintStream(sysOutContent));
    }

    @After
    public void resetOutputStream() {
        System.setOut(null);
    }

    @Test
    public void testPrimeAnagramCounterCorrectness() {
        // Exercise SUT
        Main.main(new String[0]);

        // Verify behaviour
        assertThat(sysOutContent.toString(), is(equalTo(EXPECTED_OUTPUT)));
    }

    @Test
    public void testSortingAnagramCounterCorrectness() {
        // Exercise SUT
        Main.main(new String[] {"sorting"});

        // Verify behaviour
        assertThat(sysOutContent.toString(), is(equalTo(EXPECTED_OUTPUT)));
    }
}
