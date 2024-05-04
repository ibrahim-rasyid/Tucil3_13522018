package algorithm;

import java.util.List;
import java.util.Set;

public class GBFS {
    private String start_word;

    private String end_word;

    private List<String> path;

    private int word_searched;

    private int cost;

    private Set<String> dict;

    private long exe_time;

    public GBFS(String start, String end) {
        start_word = start;
        end_word = end;
        path = search();
        cost = getCost(end_word);
    }

    public List<String> search() {
        return null;
    }

    public int getCost(String word) {
        return 2;
    }
}
