package selection._024;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static boolean[] visited;
    static List<List<Integer>> g = new ArrayList<>();
    static int[] inTime;
    static int[] outTime;
    static int time = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        inTime = new int[n + 1];
        outTime = new int[n + 1];

        // 0-indexは空にしておく
        g.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            sc.nextInt();
            int k = sc.nextInt();
            for (int j = 0; j < k; j++) {
                int v = sc.nextInt();
                list.add(v);
            }
            g.add(list);
        }
        sc.close();

        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            dfs(i);
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(i + " " + inTime[i] + " " + outTime[i]);
        }
    }

    static void dfs(int u) {
        // 発見時刻を更新
        inTime[u] = ++time;

        // 訪問済みにする
        visited[u] = true;

        // uから隣接する未訪問の頂点を検知する
        for (int i = 0; i < g.get(u).size(); i++) {
            int v = g.get(u).get(i);
            if (visited[v]) {
                continue;
            }
            dfs(v);
        }

        // 終了時刻を更新
        outTime[u] = ++time;
    }
}
