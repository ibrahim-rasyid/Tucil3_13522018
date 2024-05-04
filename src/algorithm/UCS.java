package algorithm;

import java.util.*;
import algorithm.Node;

public class UCS {
    private String start_word;

    private String end_word;

    private List<String> path;

    private int word_searched;

    private int cost;

    private Set<String> dict;

    private long exe_time;

    public UCS(String start, String end, Set<String> dict) {
        start_word = start.toUpperCase();
        end_word = end.toUpperCase();
        this.dict = dict;
        path = search();
        cost = getCost(end_word);
    }

    public List<String> search() {
        Map<String, String> parent = new HashMap<>();
        Node start_node = new Node(start_word, 0);
        NodeComparator nc = new NodeComparator();
        PriorityQueue<Node> pq = new PriorityQueue<>(nc);
        Set<String> visited = new HashSet<>();

        pq.add(start_node);
        visited.add(start_word);

        long start_time = System.nanoTime();
        while (!pq.isEmpty()) {
            Node current_node = pq.poll();
            // System.out.println(current_node.getInfo());
            if (current_node.getInfo().equals(end_word)) {
                long end_time = System.nanoTime();
                exe_time = (end_time-start_time)/1000000;
                word_searched = visited.size();
                return makePath(start_word, end_word, parent);
            }
            List<String> child_words = getChildNode(current_node.getInfo());
            for (String child_word : child_words) {
                if (!visited.contains(child_word)) {
                    parent.put(child_word, current_node.getInfo());
                    Node child_node = new Node(child_word, getCost(child_word));
                    pq.add(child_node);
                    visited.add(child_word);
                }
            }
        }
        long end_time = System.nanoTime();
        exe_time = (end_time-start_time)/1000000;
        return null;
    }

    public List<String> makePath(String start, String end, Map<String, String> parentMap) {
        List<String> path = new ArrayList<>();
        String current = end;
        while (!current.equals(start)) {
            path.add(0, current);
            current = parentMap.get(current);
            if (current == null) {
                break;
            }
        }
        path.add(0, start);
        return path;
    }
    
    public List<String> getChildNode(String word) {
        List<String> child_node = new ArrayList<>();
        for (int i=0; i<word.length(); i++) {
            char[] chars = word.toCharArray();
            for (char c='A'; c<'Z'; c++) {
                chars[i] = c;
                String new_word = new String(chars).toUpperCase();
                if (dict.contains(new_word)) {
                    child_node.add(new_word);
                }
            }
        }
        return child_node;
    }

    public int getCost(String word) {
        int cost = 0;
        char[] start_chars = start_word.toCharArray();
        char[] word_chars = word.toCharArray();
        for (int i=0; i<word_chars.length; i++) {
            if (start_chars[i] != word_chars[i]) {
                cost++;
            }
        }
        return cost;
    }

    public void showResult() {
        if (path != null) {
            System.out.printf("%s found from %d words in %d ms\n", end_word, word_searched, exe_time);
            System.out.println("Path of search: ");
            for (int i=0; i<path.size(); i++) {
                if (i != 0) {
                    System.out.print(" -> ");
                }
                System.out.print(path.get(i));
            }
            System.out.println();
        } else {
            System.out.printf("No path found from %s to %s\n", start_word, end_word);
        }
    }

    public List<String> getPath() {
        return this.path;
    }
}