package A68;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        MaximumFlow mf = new MaximumFlow(n);
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            mf.addEdge(a, b, c);
        }
        sc.close();

        System.out.println(mf.maxFlow(1, n));
    }
}

class MaximumFlow {
    int size;
    boolean[] visited;
    ArrayList<Edge>[] g;

    MaximumFlow(int n) {
        size = n;
        visited = new boolean[n + 1];
        g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
    }

    void addEdge(int a, int b, int c) {
        // Edgeコンストラクタに直接サイズを渡すとバグるから注意
        int currentA = g[a].size();
        int currentB = g[b].size();
        g[a].add(new Edge(b, c, currentB));
        g[b].add(new Edge(a, 0, currentA));
    }

    // スタートからposを経由してgoalまで流すことのできる経路における最小流動
    int dfs(int pos, int goal, int flow) {
        if (pos == goal) {
            return flow;
        }
        visited[pos] = true;

        for (int i = 0; i < g[pos].size(); i++) {
            Edge e = g[pos].get(i);
            if (e.cap == 0) {
                continue;
            }
            if (visited[e.to]) {
                continue;
            }

            int f = dfs(e.to, goal, Math.min(flow, e.cap));

            if (f >= 1) {
                e.cap -= f;
                g[e.to].get(e.rev).cap += f;
                return f;
            }
        }

        return 0;
    }

    int maxFlow(int st, int goal) {
        int result = 0;
        while (true) {
            Arrays.fill(visited, false);
            int flow = dfs(st, goal, 1000000000);
            if (flow == 0) {
                break;
            }
            result += flow;
        }

        return result;
    }
}

class Edge {
    int to;
    int cap;
    int rev;

    Edge(int to, int cap, int rev) {
        this.to = to;
        this.cap = cap;
        this.rev = rev;
    }
}
