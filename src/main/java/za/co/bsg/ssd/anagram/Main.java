package za.co.bsg.ssd.anagram;

public class Main {

    public static void main(String[] args) {
        /**
         * Provide implementations for {@link za.co.bsg.ssd.anagram.reader.WordList},
         * {@link za.co.bsg.ssd.anagram.counter.AnagramCounter}, and
         * {@link za.co.bsg.ssd.anagram.printer.AnagramPrinter}. Then replace the nulls in the instantiation
         * below with your implementations.
         */
        AnagramCalculator anagramCalculator = new AnagramCalculator(null, null, null);

        try {
            anagramCalculator.run();
        } catch (NullPointerException e) {
            System.err.println("Did you forget to provide your implementations to the AnagramCalculator?");
            throw e;
        }
    }
}
