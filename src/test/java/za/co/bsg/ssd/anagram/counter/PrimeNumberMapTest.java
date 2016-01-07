package za.co.bsg.ssd.anagram.counter;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrimeNumberMapTest {

    @Test
    public void getPrime_shouldReturnUniquePrimesInOrder() throws Exception {
        // Set up fixture
        PrimeNumberMap map = new PrimeNumberMap();

        // Verify behaviour
        assertThat(map.getPrime('a'), equalTo(2));
        assertThat(map.getPrime('b'), equalTo(3));
        assertThat(map.getPrime('c'), equalTo(5));
        assertThat(map.getPrime('c'), equalTo(5));
        assertThat(map.getPrime('b'), equalTo(3));
    }
}