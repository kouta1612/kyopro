package selection._087;

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[m];
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt() - 1;
            b[i] = sc.nextInt() - 1;
        }
        sc.close();

        long[] result = new long[m];
        result[m - 1] = (long)n * (long)(n - 1) / 2L;
        UnionFind uf = new UnionFind(n);
        for (int i = m - 1; i >= 1; i--) {
            if (uf.same(a[i], b[i])) {
                result[i - 1] = result[i];
                continue;
            }
            result[i - 1] = result[i] - uf.size(a[i]) * uf.size(b[i]);
            uf.unite(a[i], b[i]);
        }

        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0; i < m; i++) {
            out.println(result[i]);
        }

        out.flush();
    }
}

class UnionFind {
    // par[i] : 頂点iの親に該当する頂点番号
    // size[i]: 頂点iを根とする集合の要素の数
    int[] par;
    long[] size;

    UnionFind(int n) {
        par = new int[n];
        size = new long[n];
        for (int i = 0; i < n; i++) {
            par[i] = -1;
            size[i] = 1;
        }
    }

    public void unite(int u, int v) {
        int rootU = root(u);
        int rootV = root(v);

        // uとvが同じグループの場合は結合処理を行わない
        if (rootU == rootV) {
            return;
        }

        // UnionBySize
        if (size[rootU] < size[rootV]) {
            par[rootU] = rootV;
            size[rootV] += size[rootU];
        } else {
            par[rootV] = rootU;
            size[rootU] += size[rootV];
        }
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
