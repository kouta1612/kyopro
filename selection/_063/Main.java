package selection._063;

import java.util.Scanner;

public class Main {
    static final long INF = 1L << 60;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] dist = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = sc.nextLong();
            }
        }
        sc.close();

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] == INF || dist[k][j] == INF || dist[i][j] == INF) {
                        continue;
                    }
                    if (i == k || k == j || i == j) {
                        continue;
                    }
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        System.out.println(-1);
                        return;
                    }
                    if (dist[i][k] + dist[k][j] == dist[i][j]) {
                        dist[i][j] = INF;
                    }
                }
            }
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == INF) {
                    continue;
                }
                sum += dist[i][j];
            }
        }

        System.out.println(sum / 2);
    }
}
