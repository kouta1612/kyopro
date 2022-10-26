package selection._007;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
        }
        sc.close();

        int result = 0;
        for (Entry<Integer, ArrayList<Integer>> entry1 : map.entrySet()) {
            for (Entry<Integer, ArrayList<Integer>> entry2 : map.entrySet()) {
                for (Integer y1 : entry1.getValue()) {
                    for (Integer y2 : entry2.getValue()) {
                        int x1 = entry1.getKey();
                        int x2 = entry2.getKey();
                        if (x1 < x2) {
                            if (map.containsKey(x2 - y2 + y1) && map.get(x2 - y2 + y1).contains(y2 + x2 - x1)
                                    && map.containsKey(
                                            x1 - y2 + y1)
                                    && map.get(x1 - y2 + y1).contains(y1 + x2 - x1)) {
                                int diffX = Math.abs(x2 - x1);
                                int diffY = Math.abs(y2 - y1);
                                result = Math.max(result, diffX * diffX + diffY * diffY);
                            }
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }
}
