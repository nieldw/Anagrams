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
        return string.chars()
                .map(c -> primeNumberMap.getPrime((char) c))
                .reduce(1, (product, prime) -> product * prime);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Word && hashCode() == obj.hashCode();
    }
}
