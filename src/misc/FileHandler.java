package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class FileHandler {
    public static Set<String> readDict(BufferedReader br) throws IOException {
        Set<String> dict = new HashSet<>();
        for (String curr_line = br.readLine(); curr_line!=null; br.readLine()) {
            dict.add(curr_line);
        }
        return dict;
    }
}
