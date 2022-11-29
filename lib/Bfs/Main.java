package lib.Bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 1));
        edges.add(new Edge(1, 2, 1));

        long[] dist = bfs(0, 3, edges);
        System.out.println(Arrays.toString(dist));
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

class Edge {
    int source, dest;
    long weight;

    Edge(int source, int dest, long weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}

class Graph {
    static List<List<Edge>> graph = new ArrayList<>();

    static List<List<Edge>> build(int n, List<Edge> edges) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (Edge edge : edges) {
            graph.get(edge.source).add(edge);
        }

        return graph;
    }
}
