package B62;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayDeque<Integer> path;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[m];
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        sc.close();

        path = new ArrayDeque<>();
        visited = new boolean[n + 1];
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            g[a[i]].add(b[i]);
            g[b[i]].add(a[i]);
        }
        dfs(1, n, g);

        StringBuilder builder = new StringBuilder();
        for (int p : path) {
            builder.append(p).append(" ");
        }

        System.out.println(builder.toString().trim());
    }

    static void dfs(int st, int n, ArrayList<Integer>[] g) {
        visited[st] = true;
        path.addLast(st);
        for (int i = 0; i < g[st].size(); i++) {
            int next = g[st].get(i);
            if (!visited[next]) {
                dfs(next, n, g);
            }
        }
        if (path.getLast() != n) {
            path.removeLast();
        }
        return;
    }
}
