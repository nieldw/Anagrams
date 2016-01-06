package za.co.bsg.ssd.anagram.reader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class UrlDictionaryWordList implements WordList {

    private final URL fileUrl;
    private final Charset charset;

    public UrlDictionaryWordList(URL fileUrl, Charset charset) {
        this.fileUrl = fileUrl;
        this.charset = charset;
    }

    @Override
    public List<String> readAll() {
        try {
            return Files.readAllLines(Paths.get(fileUrl.toURI()), charset);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return new LinkedList<>();
        }
    }
}
