package algorithm;

import java.util.Comparator;

public class Node {
    private String info;
    private Integer cost;

    public Node(String word, Integer cost) {
        info = word;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public String getInfo() {
        return info;
    }
}

class NodeComparator implements Comparator<Node> {
    @Override
    public int compare(Node n1, Node n2) {
        return n1.getCost()-n2.getCost();
    }
}