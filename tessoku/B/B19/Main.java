package B19;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int W = sc.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        // dp[i][j]: 1からiまでの番号がついた品物をいくつか選んだ時の価値がjとなる最小の重さ
        long[][] dp = new long[n + 1][51];

        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], 50);
        }
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 50; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - v[i - 1] >= 0) {
                    dp[i][j] = Math.min(dp[i - 1][j - v[i - 1]] + w[i - 1], dp[i - 1][j]);
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));

        long result = 0;
        for (int i = 0; i <= 50; i++) {
            if (dp[n][i] <= W) {
                result = Math.max(result, i);
            }
        }

        System.out.println(result);

        sc.close();
    }
}
