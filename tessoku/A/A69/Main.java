package A69;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] s = new String[n][n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next().split("");
        }
        sc.close();

        MaximumFlow mf = new MaximumFlow(2 * n + 4);
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                if (s[i][j].equals("#")) {
                    mf.addEdge(i + 1, n + (j + 1), 1);
                }
            }
        }
        for (int i = 0; i < s.length; i++) {
            mf.addEdge(2 * n + 1, i + 1, 1);
            mf.addEdge(n + (i + 1), 2 * n + 2, 1);
        }

        System.out.println(mf.maxFlow(2 * n + 1, 2 * n + 2));
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

class MaximumFlow {
    int size;
    boolean[] visited;
    List<List<Edge>> g = new ArrayList<>();

    MaximumFlow(int n) {
        size = n;
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
    }

    void addEdge(int from, int to, int cap) {
        int curA = g.get(from).size();
        int curB = g.get(to).size();
        g.get(from).add(new Edge(to, cap, curB));
        g.get(to).add(new Edge(from, 0, curA));
    }

    int dfs(int pos, int goal, int curFlow) {
        if (pos == goal) {
            return curFlow;
        }

        visited[pos] = true;

        for (int i = 0; i < g.get(pos).size(); i++) {
            Edge e = g.get(pos).get(i);
            if (visited[e.to]) {
                continue;
            }
            if (e.cap == 0) {
                continue;
            }

            int minFlow = dfs(e.to, goal, Math.min(curFlow, e.cap));
            if (minFlow >= 1) {
                e.cap -= minFlow;
                g.get(e.to).get(e.rev).cap += minFlow;
                return minFlow;
            }
        }

        return 0;
    }

    int maxFlow(int s, int t) {
        int result = 0;
        while (true) {
            for (int i = 1; i <= size; i++) {
                visited[i] = false;
            }
            int minFlow = dfs(s, t, 1 << 30);
            if (minFlow == 0) {
                break;
            }
            result += minFlow;
        }

        return result;
    }
}