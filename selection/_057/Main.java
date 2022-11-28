package selection._057;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Edge> edges = new ArrayList<>();
        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0; i < k; i++) {
            int t = sc.nextInt();
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            if (t == 0) {
                Dijkstra dijkstra = new Dijkstra(n, edges);
                long[] dist = dijkstra.build(u);
                if (dist[v] == 1L << 60) {
                    out.println(-1);
                } else {
                    out.println(dist[v]);
                }
            } else {
                int e = sc.nextInt();
                edges.add(new Edge(u, v, e));
                edges.add(new Edge(v, u, e));
            }
        }
        sc.close();
        out.flush();
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
