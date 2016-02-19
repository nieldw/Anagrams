BSG Anagrams Code Assignment
============================

[![Build Status](https://travis-ci.org/nieldw/Anagrams.svg)](https://travis-ci.org/nieldw/Anagrams)

As part of our recruitment process, to help us to understand your level of proficiency we would like you to complete a 
simple programming assignment. Your code to solve this assignment should be in a 'production-ready' state, i.e. it 
should be suitable for committing to a production codebase for an application that has an indefinite lifespan. This code
also needs to be easily maintainable by a team of developers over the application's lifespan. Unit tests are especially
useful to drive the design of your solution (TDD) and to ensure it is maintainable. Therefore you should include any 
automated tests that you may create in your submission. Following good naming conventions also support maintainability.

Instructions
------------

This assignment requires you to write a small java application that reads in the English dictionary (included in the
resources directory) and calculates the number of anagrams that exist for each word length. As an example ‘friend’, 
‘refind’, ‘finder’ would count as 3, whereas ‘monster’ and ‘mentors’ would count as 2, etc. The output should show how 
many matches occurred per word length, so using the above example, the 6 letter words would have 3 and the 7 letter 
words would have 2. The output of the application should be the word length and number of anagrams in the dictionary for
words of that length. The output should be ordered by word length in descending order.
 
For example: (Please note that these are not the correct outputs, but demonstrates the correct format.)
> For words '12' characters long there are ' 2' anagrams.  
> For words '11' characters long there are ' 3' anagrams.  
> .  
> .  
> .  
> For words ' 3' characters long there are '15' anagrams.  

### Implementation
The assignment requires you provide implementations to three interfaces: `WordList`, which must read the contents of the
dictionary file and return a list of strings, `AnagramCounter`, which must determine the number of anagrams for each 
word length, and `AnagramPrinter`, which is responsible for printing the output to `System.out`.
Provide your implementations to the `AnagramCalculator` instantiated in `Main`. All of these classes can be found 
already in the `src\main\java` directory. You are free to design each implementation as you choose, and may use as many
or few collaborating classes as you choose. You are encouraged to include unit tests.

The project is built using Maven and already includes the dependencies for `junit` and `mockito`. You may add any other
dependencies you require.

### Edge cases
1. All characters should be treated in the same way. Characters with diacritics should receive no special treatment.
1. Capitalisation does not matter.
1. Where a word occurs twice in the dictionary due to capitalisation (for example 'Booth' and 'booth'), that word should
   only be considered once.
1. If there are no anagrams for a particular word length it should not be included in the output.
1. Single characters are not considered as anagrams. For example, 'W' and 'w' are not two anagrams.

### Running your code
You can compile and run your code in single step using the following command from the project root:

    $ mvn compile exec:java
    
Ensure that this command completes successfully before submitting your assignment:

    $ mvn package
    
### Checking your results
You can check that your results match the expected output by running the following command from the project root: 

    $ mvn verify
