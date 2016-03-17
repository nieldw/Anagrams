Anagrams Counter
================

[![Build Status](https://travis-ci.org/nieldw/Anagrams.svg)](https://travis-ci.org/nieldw/Anagrams)

The purpose of this project is to write a small Java application that reads the English dictionary (included in the 
resources directory) and calculates the number of anagrams that exist for each word length. As an example ‘friend’, 
‘refind’, ‘finder’ would count as 3, and ‘monster’ and ‘mentors’ would count as 2. The output should show how many 
matches occurred per word length, so using the above example, the 6 letter words would have 3 and the 7 letter words 
would have 2. If there were an additional 6 letter word, for example ‘return’, but no anagram of this word, then the 
result would remain 3 anagrams for 6 letter words. However, if we also included the word ‘turner’, which is an anagram 
of ‘return’, the result would now be 5 anagrams for 6 letter words.

The output of the application should be the word length and number of anagrams in the dictionary for words of that 
length. The output should be ordered by word length in descending order.
 
For example: (Please note that these are not the correct outputs, but demonstrates the correct format.)
> For words '12' characters long there are ' 2' anagrams.  
> For words '11' characters long there are ' 3' anagrams.  
> .  
> .  
> For words ' 7' characters long there are ' 2' anagrams.  
> For words ' 6' characters long there are ' 5' anagrams.  
> .  
> For words ' 3' characters long there are '15' anagrams.  

### Implementation
The implementation relies on three interfaces: `WordList`, which must read the contents of the dictionary file and 
return a list of strings, `AnagramCounter`, which must determine the number of anagrams for each word length, and 
`AnagramPrinter`, which is responsible for printing the output to `System.out`. The implementations are provided to the 
`AnagramCalculator` instantiated in `Main`. There are two different implementations of `AnagramCounter`. The one relies
on the unique-prime-factorization theorem, the other simply sorts the characters of a word to determine whether it is an
anagram of another word and was used to compare its results with that of the first implementation.

The project is built using Maven.

### Edge cases
1. All characters should be treated in the same way. Characters with diacritics should receive no special treatment.
1. Capitalisation does not matter.
1. Where a word occurs twice in the dictionary due to capitalisation (for example 'Booth' and 'booth'), that word should
   only be considered once.
1. If there are no anagrams for a particular word length it should not be included in the output.
1. Single characters are not considered as anagrams. For example, 'W' and 'w' are not two anagrams.

### Running the code
You can compile and run the project in single step using the following command from the project root:

    $ mvn compile exec:java
    
To compile and run the project with the sorting anagram counter, provide one command line argument to the program:

    $ mvn compile exec:java -Dexec.args="sorted"
