package A19;

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

        // dp[i][j]: 1からiまでの番号がついた品物をいくつか選んだ時の重さがj以下となる最大の価値
        long[][] dp = new long[n + 1][W + 1];

        // i番目の品物を選ばない時: dp[i - 1][j] -> dp[i][j]
        // i番目の品物を選ぶ時: max(dp[i - 1][j - w[i - 1]], dp[i - 1][j]) -> dp[i][j]
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                // 選ばない時
                dp[i][j] = dp[i - 1][j];
                // 選べる時
                if (j - w[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j - w[i - 1]] + v[i - 1], dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[n][W]);

        sc.close();
    }
}
