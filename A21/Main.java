package A21;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n + 1];
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
            a[i] = sc.nextInt();
        }
        sc.close();

        // dp[l][r]: 区間[l,r]のブロックがある状態での合計得点の最大
        int[][] dp = new int[n + 1][n + 1];
        dp[1][n] = 0;

        // length: r - l
        for (int length = n - 2; length >= 0; length--) {
            for (int l = 1; l <= n - length; l++) {
                int r = l + length;

                int leftScore = 0;
                if (1 <= l - 1 && l - 1 <= n && l <= p[l - 1] && p[l - 1] <= r) {
                    leftScore = a[l - 1];
                }

                int rightScore = 0;
                if (1 <= r + 1 && r + 1 <= n && l <= p[r + 1] && p[r + 1] <= r) {
                    rightScore = a[r + 1];
                }

                if (l == 1) {
                    dp[l][r] = dp[l][r + 1] + rightScore;
                } else if (r == n) {
                    dp[l][r] = dp[l - 1][r] + leftScore;
                } else {
                    dp[l][r] = Math.max(dp[l - 1][r] + leftScore, dp[l][r + 1] + rightScore);
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, dp[i][i]);
        }

        System.out.println(result);
    }
}
