package lib.UnionFind;

public class Main {
    public static void main(String[] args) {
        UnionFind uf = new UnionFind(5);
        uf.unite(0, 1);
        uf.unite(1, 2);
        System.out.println(uf.same(0, 1));
        System.out.println(uf.same(0, 2));
        System.out.println(uf.same(0, 3));
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
