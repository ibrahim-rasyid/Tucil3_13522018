import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.File;
import java.util.*;

import algorithm.*;
import misc.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FileHandler fh = new FileHandler();
        Set<String> dict = fh.readDict("src/dictionary/dictionary.txt");
        InputHandler ih = new InputHandler();
        String[] words = ih.getWords(dict);
        String start_word = words[0].toUpperCase();
        String end_word = words[1].toUpperCase();
        dict = fh.trimDict(dict, start_word.length());
        Integer type = ih.getAlgoType();
        if (type == 1) {
            UCS search = new UCS(start_word, end_word, dict);
            search.showResult();
        } else if (type == 2) {

        } else {

        }
    }
}
