package lib.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 3));
        edges.add(new Edge(1, 2, 2));

        Dijkstra dijkstra = new Dijkstra(3, edges);
        long[] dist = dijkstra.build(0);
        System.out.println(Arrays.toString(dist));
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
        pq = new PriorityQueue<>();
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

class Edge {
    int source, dest;
    long weight;

    Edge(int source, int dest, long weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}

class Node implements Comparable<Node> {
    int vertex;
    long weight;

    Node(int vertex, long weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node node) {
        return (int) (this.weight - node.weight);
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
