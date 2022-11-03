package A70;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] x = new int[m];
        int[] y = new int[m];
        int[] z = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            z[i] = sc.nextInt();
        }
        sc.close();

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] g = new ArrayList[1 << n];
        for (int i = 0; i < 1 << n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < m; j++) {
                // ランプの操作の状態を逆順に読む
                int rampState = (1 << (n - x[j])) + (1 << (n - y[j])) + (1 << (n - z[j]));
                int nextV = i ^ rampState;
                g[i].add(nextV);
            }
        }

        int start = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 1) {
                start += 1 << (n - i - 1);
            }
        }

        int[] dist = new int[1 << n];
        Arrays.fill(dist, -1);
        dist[start] = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addFirst(start);
        while (!queue.isEmpty()) {
            int v = queue.pollLast();
            for (Integer nextV : g[v]) {
                if (dist[nextV] == -1) {
                    dist[nextV] = dist[v] + 1;
                    queue.addFirst(nextV);
                }
            }
        }

        System.out.println(dist[(1 << n) - 1]);
    }
}
