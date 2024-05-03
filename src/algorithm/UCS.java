package algorithm;

public class UCS {
    private String start_word;

    private String end_word;

    private String[] path;

    private int cost;

    public UCS(String start, String end) {
        start_word = start;
        end_word = end;
        path = search();
        cost = getCost(path);
        System.out.println("Test");
    }

    public String[] search() {
        String[] s = {};
        return s;
    }

    public int getCost(String[] path) {
        return 2;
    }
}
