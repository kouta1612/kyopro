package A62;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static boolean[] found;

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

        found = new boolean[n + 1];

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            g[a[i]].add(b[i]);
            g[b[i]].add(a[i]);
        }

        dfs(1, g);

        boolean result = true;
        for (int i = 1; i <= n; i++) {
            if (found[i] == false) {
                result = false;
            }
        }

        if (result) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
        }
    }

    static void dfs(int st, ArrayList<Integer>[] g) {
        found[st] = true;
        for (int i = 0; i < g[st].size(); i++) {
            int next = g[st].get(i);
            if (found[next] == false) {
                dfs(next, g);
            }
        }
        return;
    }
}
