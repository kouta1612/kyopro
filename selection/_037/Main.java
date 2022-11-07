package selection._037;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] c = new int[m];
        for (int i = 0; i < m; i++) {
            c[i] = sc.nextInt();
        }
        sc.close();

        // dp[i][j]: c1,c2,...,ciまでのi種類のコインを使ってj円を支払うには最小で何枚のコインが必要か
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = 1<<30;
            }
        }
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j - c[i - 1] >= 0) {
                    dp[i][j] = Math.min(dp[i][j - c[i - 1]] + 1, dp[i - 1][j]);
                }
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
            }
        }

        System.out.println(dp[m][n]);
    }
}
