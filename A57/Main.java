package A57;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        int[] x = new int[q];
        int[] y = new int[q];
        for (int i = 0; i < q; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        sc.close();

        // dp[i][j]: 穴jにいる時の2^i日後にいる穴番号
        int[][] dp = new int[30][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[0][i] = a[i];
        }

        for (int i = 1; i < 30; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][dp[i - 1][j]];
            }
        }

        for (int i = 0; i < q; i++) {
            System.out.println(getMigrationPoint(x[i], y[i], dp));
        }
    }

    static int getMigrationPoint(int x, int y, int[][] dp) {
        int current = x;
        for (int i = 0; y >= (1 << i); i++) {
            if ((y >> i) % 2 == 1) {
                current = dp[i][current];
            }
        }

        return current;
    }
}
