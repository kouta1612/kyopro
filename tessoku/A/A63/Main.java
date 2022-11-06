package A63;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Queue<Integer> q;
    static int[] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] g = new ArrayList[n + 1];

        q = new ArrayDeque<Integer>();
        dist = new int[n + 1];
        Arrays.fill(dist, -1);

        dist[1] = 0;
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            g[a].add(b);
            g[b].add(a);
        }
        sc.close();

        q.add(1);
        while (q.size() > 0) {
            int current = q.poll();
            for (int next : g[current]) {
                if (dist[next] == -1) {
                    dist[next] = dist[current] + 1;
                    q.add(next);
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        for (int i = 1; i <= n; i++) {
            out.println(dist[i]);
        }

        out.flush();
    }
}
