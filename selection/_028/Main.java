package selection._028;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int u = sc.nextInt();
            int k = sc.nextInt();
            List<Integer> list = g.get(u);
            for (int j = 0; j < k; j++) {
                int v = sc.nextInt();
                list.add(v);
            }
        }
        sc.close();

        int[] result = new int[n + 1];
        Arrays.fill(result, 1 << 30);
        result[1] = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(1);
        while (!queue.isEmpty()) {
            int u = queue.removeFirst();
            for (int v : g.get(u)) {
                if (result[v] == 1 << 30) {
                    result[v] = Math.min(result[v], result[u] + 1);
                    queue.addLast(v);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (result[i] == 1 << 30) {
                System.out.println(i + " " + -1);
            } else {
                System.out.println(i + " " + result[i]);
            }
        }
    }
}
