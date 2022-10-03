package A35;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[n][i] = a[i - 1];
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                if (i % 2 == 1) {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
                }
            }
        }

        System.out.println(dp[1][1]);
    }
}
