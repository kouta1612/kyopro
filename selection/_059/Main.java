package selection._059;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split(" ");
        int n = Integer.valueOf(line[0]);
        int m = Integer.valueOf(line[1]);
        int[] cost = new int[n];
        int[] limit = new int[n];
        for (int i = 0; i < n; i++) {
            line = reader.readLine().split(" ");
            cost[i] = Integer.valueOf(line[0]);
            limit[i] = Integer.valueOf(line[1]);
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            line = reader.readLine().split(" ");
            int u = Integer.valueOf(line[0]) - 1;
            int v = Integer.valueOf(line[1]) - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] dist = new int[n];
        // edgeNodesとedgeCostsをまとめてNodeクラスにするとMLEになるのでここでは分解している
        // edgeNodes[i][j]: 頂点iからたどることができるj番目の頂点
        // edgeCosts[i][j]: 頂点iからたどることができるj番目の頂点に行くまでのコスト
        // int[][] edgeNodes = new int[n][]とすることでi番目の頂点からたどることができる頂点の数の分だけ動的に確保できる
        int[][] edgeNodes = new int[n][];
        int[][] edgeCosts = new int[n][];
        Deque<Integer> q = new ArrayDeque<>();
        // 出発地点を全探索
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist, -1);
            dist[i] = 0;
            q.add(i);
            while (q.size() > 0) {
                int u = q.poll();
                for (int v : graph.get(u)) {
                    if (dist[v] >= 0) {
                        continue;
                    }
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }

            int size = 0;
            // 到着地点を全探索
            for (int j = 0; j < n; j++) {
                if (i == j || dist[j] > limit[i]) {
                    continue;
                }
                size++;
            }

            edgeNodes[i] = new int[size];
            edgeCosts[i] = new int[size];
            for (int j = 0; j < n; j++) {
                if (i == j || dist[j] > limit[i]) {
                    continue;
                }
                size--;
                edgeNodes[i][size] = j;
                edgeCosts[i][size] = cost[i];
            }
        }

        Queue<Node> pq = new PriorityQueue<>(new DijkstraComparator());
        pq.add(new Node(0, 0));
        int[] costs = new int[n];
        Arrays.fill(costs, 1 << 30);
        costs[0] = 0;
        while (pq.size() > 0) {
            Node node = pq.poll();
            if (costs[node.vertex] < node.weight) {
                continue;
            }
            for (int i = 0; i < edgeNodes[node.vertex].length; i++) {
                int to = edgeNodes[node.vertex][i];
                if (costs[to] > node.weight + edgeCosts[node.vertex][i]) {
                    costs[to] = node.weight + edgeCosts[node.vertex][i];
                    pq.add(new Node(to, costs[to]));
                }
            }
        }

        System.out.println(costs[n - 1]);
    }
}

class DijkstraComparator implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        return o1.weight > o2.weight ? 1 : -1;
    }
}

class Edge {
    int source, dest;
    int weight;

    Edge(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}

class Node {
    int vertex;
    int weight;

    Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}
