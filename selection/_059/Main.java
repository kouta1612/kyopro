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
        int[] cost = new int[n];
        int[] limit = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
            limit[i] = sc.nextInt();
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        sc.close();

        int[] dist = new int[n];
        Node[][] nodes = new Node[n][];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist, -1);
            dist[i] = 0;
            q.add(i);
            while (q.size() > 0) {
                int u = q.poll();
                for (Integer integer : graph.get(u)) {

                }
            }
        }

        List<Edge> newEdges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newEdges.add(new Edge(i, j, cost[i]));
            }
        }

        Dijkstra dijkstra = new Dijkstra(n, newEdges);
        dist = dijkstra.build(0);

        System.out.println(dist[n - 1]);
    }

    static int[] bfs(int s, int n, List<Edge> edges) {
        int[] dist = new int[n];
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
    private int[] current;
    private boolean[] isDone;
    private List<List<Edge>> graph;
    private Queue<Node> pq;

    Dijkstra(int n, List<Edge> edges) {
        current = new int[n];
        Arrays.fill(current, 1 << 30);
        isDone = new boolean[n];
        graph = Graph.build(n, edges);
        pq = new PriorityQueue<>(new DijkstraComparator());
    }

    int[] build(int s) {
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
                int cost = current[node.vertex] + edge.weight;

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
