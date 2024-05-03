package misc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileHandler {
    public Set<String> readDict(String file_path) throws IOException {
        Set<String> dict = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            String line;
            while ((line = br.readLine()) != null) {
                dict.add(line.trim());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dict;
    }
}
