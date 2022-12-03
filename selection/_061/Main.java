package selection._061;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[][] dist = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                dist[i][j] = 1L << 60;
            }
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            long d = sc.nextLong();
            dist[u][v] = d;
            dist[v][u] = d;
        }
        sc.close();

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        long result = 1L << 60;
        for (int i = 0; i < n; i++) {
            long current = 0;
            for (int j = 0; j < n; j++) {
                current = Math.max(current, dist[i][j]);
            }
            result = Math.min(result, current);
        }

        System.out.println(result);
    }
}
