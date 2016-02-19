package za.co.bsg.ssd.anagram.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileUrl.openStream(), charset));
            return bufferedReader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return new LinkedList<>();
        }
    }
}
