package selection._026;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] a = new int[n - 1];
        int[] b = new int[n - 1];
        int[] p = new int[q];
        int[] x = new int[q];
        for (int i = 0; i < n - 1; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        for (int i = 0; i < q; i++) {
            p[i] = sc.nextInt();
            x[i] = sc.nextInt();
        }
        sc.close();

        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            List<Integer> list = g.get(a[i]);
            list.add(b[i]);
        }

        int[] count = new int[n + 1];
        for (int i = 0; i < q; i++) {
            count[p[i]] += x[i];
        }

        boolean[] visited = new boolean[n + 1];
        dfs(1, count, visited, g);

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            builder.append(count[i]).append(" ");
        }

        System.out.println(builder.toString().trim());
    }

    static void dfs(int u, int[] count, boolean[] visited, List<List<Integer>> g) {
        visited[u] = true;

        for (int i = 0; i < g.get(u).size(); i++) {
            int v = g.get(u).get(i);
            if (visited[v]) {
                continue;
            }
            count[v] += count[u];
            dfs(v, count, visited, g);
        }
    }
}
