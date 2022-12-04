package selection._064;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int c = sc.nextInt();
            edges.add(new Edge(u, v, c));
        }
        sc.close();

        edges.sort(new EdgeComparator());

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

class EdgeComparator implements Comparator<Edge> {
    @Override
    public int compare(Edge o1, Edge o2) {
        return o1.weight < o2.weight ? -1 : 1;
    }
}
