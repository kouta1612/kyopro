package selection._056;

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
        int e = sc.nextInt();
        int s = sc.nextInt();

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long d = sc.nextLong();
            edges.add(new Edge(u, v, d));
        }
        sc.close();

        Dijkstra dijkstra = new Dijkstra(n, edges);
        long[] current = dijkstra.build(s);

        for (int i = 0; i < n; i++) {
            if (current[i] == 1L << 60) {
                System.out.println("INF");
            } else {
                System.out.println(current[i]);
            }
        }
    }
}

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