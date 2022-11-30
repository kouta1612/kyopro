package selection._059;

import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] cost = new long[n];
        int[] limitPath = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextLong();
            limitPath[i] = sc.nextInt();
        }

        List<Edge> edges = new ArrayList<>();
        boolean[][] connected = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            edges.add(new Edge(u, v, 1));
            edges.add(new Edge(v, u, 1));
            connected[u][v] = connected[v][u] = true;
        }

        sc.close();

        // TODO: 要パフォーマンス改善
        // 頂点数が比較的少ないので隣接リストではなく隣接行列を使ったほうが良いかも
        for (int i = 0; i < n; i++) {
            long[] dist = bfs(i, n, edges);
            for (int j = 0; j < n; j++) {
                // 同じ頂点はスキップ
                if (i == j) {
                    continue;
                }

                // タクシーで移動可能でなければスキップ
                if (!(1 <= dist[j] && dist[j] <= limitPath[i])) {
                    continue;
                }

                // 連結済みであればスキップ
                if (connected[i][j]) {
                    continue;
                }

                connected[i][j] = true;
            }
        }

        List<Edge> newEdges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!connected[i][j]) {
                    continue;
                }

                newEdges.add(new Edge(i, j, cost[i]));
            }
        }

        Dijkstra dijkstra = new Dijkstra(n, newEdges);
        long[] dist = dijkstra.build(0);

        System.out.println(dist[n - 1]);
    }

    static long[] bfs(int s, int n, List<Edge> edges) {
        long[] dist = new long[n];
        Deque<Integer> queue = new ArrayDeque<>();
        List<List<Edge>> graph = Graph.build(n, edges);

        Arrays.fill(dist, -1);
        dist[s] = 0;
        queue.addLast(s);
        while (!queue.isEmpty()) {
            int pos = queue.pollFirst();
            for (Edge edge : graph.get(pos)) {
                if (dist[edge.dest] >= 0) {
                    continue;
                }

                dist[edge.dest] = dist[pos] + 1;
                queue.add(edge.dest);
            }
        }

        return dist;
    }
}

/**
 * ダイクストラ法
 * (辺の重みが非負数の場合の単一始点最短経路問題を解くための最良優先探索によるアルゴリズム)
 */
class Dijkstra {
    private long[] current;
    private boolean[] isDone;
    private List<List<Edge>> graph;
    private Queue<Node> pq;

    Dijkstra(int n, List<Edge> edges) {
        current = new long[n];
        Arrays.fill(current, 1L << 60);
        isDone = new boolean[n];
        graph = Graph.build(n, edges);
        pq = new PriorityQueue<>(new DijkstraComparator());
    }

    long[] build(int s) {
        current[s] = 0;
        pq.add(new Node(s, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            // 既に確定済みならスキップ
            if (isDone[node.vertex]) {
                continue;
            }

            // 確定済みに更新
            isDone[node.vertex] = true;

            // 隣接する未確定ノードのうち最短距離となる経路があれば更新
            for (Edge edge : graph.get(node.vertex)) {
                int next = edge.dest;
                long cost = current[node.vertex] + edge.weight;

                // 最短でなければスキップ
                if (current[next] <= cost) {
                    continue;
                }

                current[next] = cost;
                pq.add(new Node(next, current[next]));
            }
        }

        return current;
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
    long weight;

    Edge(int source, int dest, long weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}

class Node {
    int vertex;
    long weight;

    Node(int vertex, long weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

class Graph {
    static List<List<Edge>> graph = null;

    static List<List<Edge>> build(int n, List<Edge> edges) {
        graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (Edge edge : edges) {
            graph.get(edge.source).add(edge);
        }

        return graph;
    }
}
