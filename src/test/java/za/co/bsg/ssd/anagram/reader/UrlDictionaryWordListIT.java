package za.co.bsg.ssd.anagram.reader;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

public class UrlDictionaryWordListIT {

    @Test
    public void readAll_shouldReturnEachLineFromTheFile() throws Exception {
        // Set up fixture
        List<String> expectedWordList = asList("Word 1", "Word 2", "Word 3");
        Path tempFile = writeToTempFile(expectedWordList);

        UrlDictionaryWordList wordList = new UrlDictionaryWordList(tempFile.toUri().toURL(), UTF_8);

        // Exercise SUT
        List<String> strings = wordList.readAll();

        // Verify behaviour
        assertThat(strings, equalTo(expectedWordList));
    }

    @Test
    public void readAllWithMissingFile_shouldReturnEmptyList() throws Exception {
        // Set up fixture
        Path missingFile = Paths.get("missing_file");
        UrlDictionaryWordList wordList = new UrlDictionaryWordList(missingFile.toUri().toURL(), UTF_8);

        // Exercise SUT
        List<String> strings = wordList.readAll();

        // Verify behaviour
        assertThat(strings, hasItems(new String[]{}));
    }

    private Path writeToTempFile(List<String> expectedWordList) throws IOException {
        Path tempFile = Files.createTempFile("test", ".file");
        BufferedWriter writer = Files.newBufferedWriter(tempFile, UTF_8);
        for (String word : expectedWordList) {
            writer.write(word + "\n");
        }
        writer.close();
        return tempFile;
    }
}