package A23;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        sc.close();

        // dp[i][S]: クーポン1からクーポンiまでいくつか選んで品物の集合Sを購入したときのクーポン券の最小枚数
        int[][] dp = new int[m + 1][(1 << n) + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= 1 << n; j++) {
                dp[i][j] = 1 << 30;
            }
        }
        dp[0][0] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < 1 << n; j++) {
                // クーポン券iを使って購入した品物の集合Sを10進数で計算
                int S = 0;
                for (int k = 0; k < n; k++) {
                    if (a[i - 1][k] == 1) {
                        S += 1 << k;
                    }
                }
                // 以前に購入した品物の集合jも考慮
                S |= j;

                // クーポン券を使わない場合
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);

                // クーポン券を使う場合
                dp[i][S] = Math.min(dp[i][S], dp[i - 1][j] + 1);
            }
        }

        int result = 1 << 30;
        for (int i = 1; i <= m; i++) {
            result = Math.min(result, dp[i][(1 << n) - 1]);
        }

        if (result == 1 << 30) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}
