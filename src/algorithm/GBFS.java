package algorithm;

public class GBFS {
    private String start_word;

    private String end_word;

    private String[] path;

    private int cost;

    public GBFS(String start, String end) {
        start_word = start;
        end_word = end;
        path = search();
        cost = getCost(path);
    }

    public String[] search() {
        String[] s = {};
        return s;
    }

    public int getCost(String[] path) {
        return 2;
    }
}
