package A73;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[m];
        int[] b = new int[m];
        long[] c = new long[m];
        int[] d = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextLong();
            d[i] = sc.nextInt();
        }
        sc.close();

        @SuppressWarnings("unchecked")
        ArrayList<Pair>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            if (d[i] == 1) {
                g[a[i]].add(new Pair(b[i], c[i] * 10000 - 1));
                g[b[i]].add(new Pair(a[i], c[i] * 10000 - 1));
            } else {
                g[a[i]].add(new Pair(b[i], c[i] * 10000));
                g[b[i]].add(new Pair(a[i], c[i] * 10000));
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.cost > o2.cost ? 1 : -1;
            }
        });
        boolean kakutei[] = new boolean[n + 1];
        long cur[] = new long[n + 1];
        Arrays.fill(cur, 1L << 60);
        cur[1] = 0;
        pq.add(new Pair(1, 0));
        while (!pq.isEmpty()) {
            Pair now = pq.poll();
            if (kakutei[now.v]) {
                continue;
            }
            kakutei[now.v] = true;
            for (Pair next : g[now.v]) {
                if (cur[next.v] > cur[now.v] + next.cost) {
                    cur[next.v] = cur[now.v] + next.cost;
                    pq.add(new Pair(next.v, cur[next.v]));
                }
            }
        }

        long distance = (cur[n] + 9999) / 10000;
        long treeCount = distance * 10000 - cur[n];

        System.out.println(distance + " " + treeCount);
    }
}

class Pair {
    int v;
    long cost;

    Pair(int v, long cost) {
        this.v = v;
        this.cost = cost;
    }
}
