package B67;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Triple> g = new ArrayList<Triple>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            g.add(new Triple(a, b, c));
        }
        sc.close();

        Collections.sort(g, new Comparator<Triple>() {
            @Override
            public int compare(Triple o1, Triple o2) {
                return o1.cost < o2.cost ? 1 : -1;
            }
        });

        UnionFind uf = new UnionFind();
        uf.init(n);
        int result = 0;
        for (Triple t : g) {
            if (!uf.same(t.from, t.to)) {
                uf.union(t.from, t.to);
                result += t.cost;
            }
        }

        System.out.println(result);
    }
}

class Triple {
    int from;
    int to;
    int cost;

    Triple(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

class UnionFind {
    int[] par;
    int[] size;

    void init(int n) {
        par = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            par[i] = -1;
            size[i] = 1;
        }
    }

    int root(int x) {
        while (par[x] != -1) {
            x = par[x];
        }
        return x;
    }

    boolean same(int x, int y) {
        return root(x) == root(y);
    }

    void union(int x, int y) {
        if (same(x, y)) {
            return;
        }

        int rootX = root(x);
        int rootY = root(y);
        if (size[rootX] >= size[rootY]) {
            par[rootY] = rootX;
            size[rootX] += size[rootY];
        } else {
            par[rootX] = rootY;
            size[rootY] += size[rootX];
        }
    }
}
