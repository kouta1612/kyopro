
import java.io.PrintWriter;
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
            int s = sc.nextInt();
            int t = sc.nextInt();
            long d = sc.nextLong();
            dist[s][t] = d;
        }
        sc.close();

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] == 1L << 60 || dist[k][j] == 1L << 60) {
                        continue;
                    }
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dist[i][i] < 0) {
                System.out.println("NEGATIVE CYCLE");
                return;
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == 1L << 60) {
                    out.print("INF");
                } else {
                    out.print(dist[i][j]);
                }

                if (j == n - 1) {
                    out.println();

                } else {
                    out.print(" ");
                }
            }
        }

        out.flush();
    }
}
