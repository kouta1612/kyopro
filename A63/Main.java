package A63;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] g;
    static Queue<Integer> q;
    static boolean[] visited;
    static int[] count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        q = new ArrayDeque<Integer>();
        g = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            count[i] = 1000000000;
        }
        count[1] = 0;
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
        bfs(1);

        PrintWriter out = new PrintWriter(System.out);
        for (int i = 1; i <= n; i++) {
            if (count[i] == 1000000000) {
                out.println(-1);
            } else {
                out.println(count[i]);
            }
        }

        out.flush();
    }

    static void bfs(int pos) {
        visited[pos] = true;
        while (q.size() > 0) {
            for (int next : g[pos]) {
                if (!visited[next]) {
                    count[next] = Math.min(count[pos] + 1, count[next]);
                    q.add(next);
                }
            }
            int pop = q.poll();
            bfs(pop);
        }
    }
}
