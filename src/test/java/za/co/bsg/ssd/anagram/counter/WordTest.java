package za.co.bsg.ssd.anagram.counter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WordTest {

    @Mock
    private PrimeNumberMap primeNumberMap;

    @Test
    public void getLength_shouldReturnTheLengthOfTheString() throws Exception {
        Word word = new Word("four", primeNumberMap);
        assertThat(word.getLength(), equalTo(4));
    }

    @Test
    public void hashCode_shouldReturnThePrimeFactorProduct() throws Exception {
        Word word = new Word("four", primeNumberMap);

        when(primeNumberMap.getPrime('f')).thenReturn(2);
        when(primeNumberMap.getPrime('o')).thenReturn(3);
        when(primeNumberMap.getPrime('u')).thenReturn(5);
        when(primeNumberMap.getPrime('r')).thenReturn(7);

        assertThat(word.hashCode(), equalTo(210));
    }

    @Test
    public void equalsWithAnagram_shouldReturnTrue() throws Exception {
        Word word = new Word("are", primeNumberMap);

        when(primeNumberMap.getPrime('e')).thenReturn(2);
        when(primeNumberMap.getPrime('a')).thenReturn(3);
        when(primeNumberMap.getPrime('r')).thenReturn(5);

        assertThat(word.equals(new Word("ear", primeNumberMap)), is(true));
    }

    @Test
    public void equalsWithNonAnagram_shouldReturnFalse() throws Exception {
        Word word = new Word("are", primeNumberMap);

        when(primeNumberMap.getPrime('e')).thenReturn(2);
        when(primeNumberMap.getPrime('a')).thenReturn(3);
        when(primeNumberMap.getPrime('r')).thenReturn(5);

        assertThat(word.equals(new Word("arr", primeNumberMap)), is(false));
    }

    @Test
    public void equalsWithNonWordObject_shouldReturnFalse() throws Exception {
        Word word = new Word("are", primeNumberMap);
        //noinspection EqualsBetweenInconvertibleTypes
        assertThat(word.equals("String"), is(false));
    }
}