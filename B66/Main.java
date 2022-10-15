package B66;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(reader.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int[] a = new int[m + 1];
        int[] b = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(reader.readLine());
            a[i] = Integer.valueOf(st.nextToken());
            b[i] = Integer.valueOf(st.nextToken());
        }

        UnionFind uf = new UnionFind();
        uf.init(n);

        int q = Integer.valueOf(reader.readLine());
        int[] t = new int[q + 1];
        int[] u = new int[q + 1];
        int[] v = new int[q + 1];
        int[] x = new int[q + 1];
        boolean[] canceled = new boolean[m + 1];
        for (int i = 1; i <= q; i++) {
            st = new StringTokenizer(reader.readLine());
            t[i] = Integer.valueOf(st.nextToken());
            if (t[i] == 1) {
                x[i] = Integer.valueOf(st.nextToken());
                canceled[x[i]] = true;
            }
            if (t[i] == 2) {
                u[i] = Integer.valueOf(st.nextToken());
                v[i] = Integer.valueOf(st.nextToken());
            }
        }

        for (int i = 1; i <= m; i++) {
            if (!canceled[i]) {
                uf.union(a[i], b[i]);
            }
        }

        String[] result = new String[q + 1];
        for (int i = q; i >= 1; i--) {
            if (t[i] == 1 && canceled[x[i]]) {
                uf.union(a[x[i]], b[x[i]]);
            } else if (t[i] == 2) {
                if (uf.same(u[i], v[i])) {
                    result[i] = "Yes";
                } else {
                    result[i] = "No";
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        for (int i = 1; i <= q; i++) {
            if (t[i] == 2) {
                out.println(result[i]);
            }
        }

        out.flush();
    }
}

class UnionFind {
    int[] size;
    int[] par;

    void init(int n) {
        size = new int[n + 1];
        par = new int[n + 1];

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