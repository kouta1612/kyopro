package selection._090;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        double[] x = new double[n + m];
        double[] y = new double[n + m];
        double[] r = new double[n + m];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextDouble();
            y[i] = sc.nextDouble();
            r[i] = sc.nextDouble();
        }
        for (int i = n; i < n + m; i++) {
            x[i] = sc.nextDouble();
            y[i] = sc.nextDouble();
            r[i] = 1e5;
        }
        sc.close();

        double[][] dist = new double[n + m][n + m];
        for (int i = 0; i < n + m; i++) {
            for (int j = i + 1; j < n + m; j++) {
                double dx = x[i] - x[j];
                double dy = y[i] - y[j];
                dist[i][j] = dist[j][i] = Math.sqrt(dx * dx + dy * dy);
            }
        }

        double ok = 0;
        double ng = Arrays.stream(r).min().getAsDouble() + 1e-6;
        while (Math.abs(ok - ng) > 1e-6) {
            double mid = (ok + ng) / 2;
            if (isIntersected(n, m, mid, r, dist)) {
                ng = mid;
            } else {
                ok = mid;
            }
        }

        System.out.println(ok);
    }

    static boolean isIntersected(int n, int m, double r, double[] rs, double[][] dist) {
        for (int i = n; i < n + m; i++) {
            rs[i] = r;
        }
        for (int i = 0; i < n + m; i++) {
            for (int j = i + 1; j < n + m; j++) {
                if (rs[i] + rs[j] > dist[i][j]) {
                    return true;
                }
            }
        }

        return false;
    }
}
