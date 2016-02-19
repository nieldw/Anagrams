package za.co.bsg.ssd.anagram.counter;

public class Word {

    private String string;
    private PrimeNumberMap primeNumberMap;

    /**
     * @param string         The string word
     * @param primeNumberMap The map to reference for prime numbers
     */
    public Word(String string, PrimeNumberMap primeNumberMap) {
        this.string = string;
        this.primeNumberMap = primeNumberMap;
    }

    public int getLength() {
        return string.length();
    }

    @Override
    public int hashCode() {
        return Long.hashCode(getPrimeProduct());
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Word && getPrimeProduct() == ((Word) obj).getPrimeProduct();
    }

    private long getPrimeProduct() {
        return string.chars()
                .map(c -> primeNumberMap.getPrime((char) c))
                .asLongStream()
                .reduce(1L, (product, prime) -> product * prime);
    }
}
