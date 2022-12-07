package selection._067;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Point> xPoints = new ArrayList<>();
        List<Point> yPoints = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            xPoints.add(new Point(i, x));
            yPoints.add(new Point(i, y));
        }
        sc.close();

        Collections.sort(xPoints);
        Collections.sort(yPoints);

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            Point xPoint1 = xPoints.get(i);
            Point xPoint2 = xPoints.get(i + 1);
            edges.add(new Edge(xPoint1.num, xPoint2.num, Math.abs(xPoint1.point - xPoint2.point)));
        }

        for (int i = 0; i < n - 1; i++) {
            Point yPoint1 = yPoints.get(i);
            Point yPoint2 = yPoints.get(i + 1);
            edges.add(new Edge(yPoint1.num, yPoint2.num, Math.abs(yPoint1.point - yPoint2.point)));
        }
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

class Point implements Comparable<Point> {
    int num;
    long point;

    Point(int num, long point) {
        this.num = num;
        this.point = point;
    }

    @Override
    public int compareTo(Point o) {
        return (int) (point - o.point);
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
