package misc;

import java.util.*;

public class InputHandler {
    public String[] getWords(Set<String> dict) {
        Scanner scan = new Scanner(System.in);
        String[] words = {"", ""};
        while (words[0] == "") {
            System.out.print("Insert start word: ");
            String start = scan.nextLine();
            System.out.print("Insert end word: ");
            String end = scan.nextLine();
            if (start.length() == end.length() && dict.contains(start.toUpperCase()) && dict.contains(end.toUpperCase())) {
                words[0] = start;
                words[1] = end;
            } else {
                if (start.length() != end.length()) {
                    System.out.println("Input length differs!");
                } else {
                    System.out.println("Word not found in dictionary or not an english word!");
                }
            }
        }
        return words;
    }

    public Integer getAlgoType() {
        Scanner scan = new Scanner(System.in);
        Integer type = 0;
        while (type == 0) {
            System.out.println("Algorithm you can choose :\n1. Uniform Cost Search (UCS)\n2. Greedy Best First Search\n3. A*");
            System.out.print("Input desired algorithm (1, 2, 3): ");
            String temp = scan.nextLine();
            try {
                type = Integer.valueOf(temp);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            if (!(type == 1 || type == 2 || type == 3)) {
                System.out.printf("%d is not available!\n", type);
                type = 0;
            }
        }
        return type;
    }
}
