package selection._065;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            long c = sc.nextLong();
            edges.add(new Edge(a, b, c));
        }
        sc.close();

        Collections.sort(edges);

        long result = 0;
        int remain = n;
        UnionFind uf = new UnionFind(n);
        for (Edge edge : edges) {
            if (remain == k) {
                break;
            }
            if (uf.unite(edge.source, edge.dest)) {
                result += edge.weight;
                remain--;
            }
        }

        System.out.println(result);
    }
}

class Edge implements Comparable<Edge> {
    int source, dest;
    long weight;

    Edge(int source, int dest, long weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge edge) {
        return (int) (this.weight - edge.weight);
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
