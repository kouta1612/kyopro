package selection._026;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] a = new int[n - 1];
        int[] b = new int[n - 1];
        int[] p = new int[q];
        int[] x = new int[q];
        for (int i = 0; i < n - 1; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        for (int i = 0; i < q; i++) {
            p[i] = sc.nextInt();
            x[i] = sc.nextInt();
        }
        sc.close();

        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            List<Integer> list1 = g.get(a[i]);
            List<Integer> list2 = g.get(b[i]);
            list1.add(b[i]);
            list2.add(a[i]);
        }

        int[] count = new int[n + 1];
        for (int i = 0; i < q; i++) {
            count[p[i]] += x[i];
        }

        dfs(1, -1, count, g);

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            builder.append(count[i]).append(" ");
        }

        System.out.println(builder.toString().trim());
    }

    static void dfs(int u, int p, int[] count, List<List<Integer>> g) {
        // pを持つことで親から子にしか移動しないようにしている
        // そのためvisitedで訪れたかどうかのフラグは不要であることに注意
        for (int i = 0; i < g.get(u).size(); i++) {
            int v = g.get(u).get(i);
            if (v == p) {
                continue;
            }
            count[v] += count[u];
            dfs(v, u, count, g);
        }
    }
}
