package A66;

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        UnionFind uf = new UnionFind();
        uf.init(n);
        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (t == 1) {
                uf.update(a, b);
            }
            if (t == 2) {
                if (uf.isSame(a, b)) {
                    out.println("Yes");
                } else {
                    out.println("No");
                }
            }
        }

        sc.close();
        out.flush();
    }
}

class UnionFind {
    int[] depth;
    int[] par;

    void init(int n) {
        depth = new int[n + 1];
        par = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            par[i] = -1;
        }
    }

    int root(int x) {
        while (par[x] != -1) {
            x = par[x];
        }

        return x;
    }

    boolean isSame(int x, int y) {
        return root(x) == root(y);
    }

    void update(int x, int y) {
        if (isSame(x, y)) {
            return;
        }

        if (depth[x] >= depth[y]) {
            par[root(y)] = root(x);
            depth[y]++;
        } else {
            par[root(x)] = root(y);
            depth[x]++;
        }
    }
}