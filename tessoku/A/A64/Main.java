package A64;

import java.io.PrintWriter;
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
        @SuppressWarnings("unchecked")
        ArrayList<Pair>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a].add(new Pair(b, c));
            graph[b].add(new Pair(a, c));
        }
        sc.close();

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.cost > o2.cost ? 1 : -1;
            }
        });

        boolean[] kakutei = new boolean[n + 1];
        long[] cur = new long[n + 1];
        Arrays.fill(cur, 1000000000);
        cur[1] = 0;
        pq.add(new Pair(1, 0));

        while (pq.size() > 0) {
            Pair p = pq.poll();

            if (kakutei[p.v]) {
                continue;
            }

            kakutei[p.v] = true;
            for (int i = 0; i < graph[p.v].size(); i++) {
                Pair next = graph[p.v].get(i);
                if (!kakutei[next.v]) {
                    if (cur[next.v] > cur[p.v] + next.cost) {
                        cur[next.v] = cur[p.v] + next.cost;
                        pq.add(new Pair(next.v, cur[next.v]));
                    }
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        for (int i = 1; i <= n; i++) {
            if (cur[i] == 1000000000) {
                out.println(-1);
            } else {
                out.println(cur[i]);
            }
        }

        out.flush();
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