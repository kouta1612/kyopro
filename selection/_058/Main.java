package selection._058;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int s = sc.nextInt();
        long p = sc.nextLong();
        long q = sc.nextLong();
        boolean[] zombi = new boolean[n];
        for (int i = 0; i < k; i++) {
            int c = sc.nextInt() - 1;
            zombi[c] = true;
        }

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            edges.add(new Edge(a, b, 1));
            edges.add(new Edge(b, a, 1));
        }
        sc.close();

        Graph graph = new Graph(n, edges);
        long[] dist = bfs(n, zombi, graph);

        boolean[] danger = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (0 <= dist[i] && dist[i] <= s) {
                danger[i] = true;
            }
        }

        List<Edge> newEdges = new ArrayList<>();
        for (Edge edge : edges) {
            // ゾンビの道は通ることができないのでスキップ
            if (zombi[edge.dest]) {
                continue;
            }

            // 最後の宿にはhすく泊する必要がないのでコストはゼロ
            if (edge.dest == n - 1) {
                newEdges.add(new Edge(edge.source, edge.dest, 0));
            }

            // 危険な道かそうでないかでコストを算出
            if (danger[edge.dest]) {
                newEdges.add(new Edge(edge.source, edge.dest, q));
            } else {
                newEdges.add(new Edge(edge.source, edge.dest, p));
            }
        }

        Dijkstra dijkstra = new Dijkstra(n, newEdges);
        long[] cur = dijkstra.build(0);

        System.out.println(cur[n - 1]);
    }

    static long[] bfs(int n, boolean[] zombi, Graph graph) {
        long[] dist = new long[n];
        Deque<Integer> queue = new ArrayDeque<>();

        Arrays.fill(dist, -1);
        for (int i = 0; i < n; i++) {
            if (zombi[i]) {
                queue.addLast(i);
                dist[i] = 0;
            }
        }

        while (!queue.isEmpty()) {
            int pos = queue.pollFirst();
            for (Edge edge : graph.edgeList.get(pos)) {
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
    private Graph g;
    private Queue<Node> pq;

    Dijkstra(int n, List<Edge> edges) {
        current = new long[n];
        Arrays.fill(current, 1L << 60);
        isDone = new boolean[n];
        g = new Graph(n, edges);
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
            for (Edge edge : g.edgeList.get(node.vertex)) {
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
    List<List<Edge>> edgeList = new ArrayList<>();

    Graph(int n, List<Edge> edges) {
        for (int i = 0; i < n; i++) {
            edgeList.add(new ArrayList<>());
        }
        for (Edge edge : edges) {
            edgeList.get(edge.source).add(edge);
        }
    }
}
