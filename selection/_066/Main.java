package selection._066;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }

            double[] x = new double[n];
            double[] y = new double[n];
            double[] z = new double[n];
            double[] r = new double[n];
            for (int i = 0; i < n; i++) {
                x[i] = sc.nextDouble();
                y[i] = sc.nextDouble();
                z[i] = sc.nextDouble();
                r[i] = sc.nextDouble();
            }

            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    double dist = Math.sqrt((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]) + (z[i] - z[j]) * (z[i] - z[j]));
                    dist = Math.max(0, dist - (r[i] + r[j]));
                    edges.add(new Edge(i, j, dist));
                }
            }

            Collections.sort(edges);

            UnionFind uf = new UnionFind(n);
            double result = 0;
            for (Edge edge : edges) {
                if (uf.unite(edge.source, edge.dest)) {
                    result += edge.weight;
                }
            }

            out.printf("%.3f\n", result);
        }

        out.flush();
        sc.close();
    }
}

class Edge implements Comparable<Edge> {
    int source, dest;
    double weight;

    Edge(int source, int dest, double weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        if (weight < o.weight) {
            return -1;
        } else if (weight > o.weight) {
            return 1;
        } else {
            return 0;
        }
    }
}

class UnionFind {
    // par[i] : 頂点iの親に該当する頂点番号
    // size[i]: 頂点iを根とする木の頂点数
    int[] par, size;

    UnionFind(int n) {
        par = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = -1;
            size[i] = 1;
        }
    }

    public boolean unite(int u, int v) {
        int rootU = root(u);
        int rootV = root(v);

        // uとvが同じグループの場合は結合処理を行わない
        if (rootU == rootV) {
            return false;
        }

        // UnionBySize
        if (size[rootU] < size[rootV]) {
            par[rootU] = rootV;
            size[rootV] += size[rootU];
        } else {
            par[rootV] = rootU;
            size[rootU] += size[rootV];
        }

        return true;
    }

    public boolean same(int u, int v) {
        return root(u) == root(v);
    }

    public long size(int x) {
        int rootX = root(x);
        return size[rootX];
    }

    private int root(int x) {
        if (par[x] == -1) {
            return x;
        }

        return root(par[x]);
    }
}
