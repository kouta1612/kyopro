package selection._039;

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

        // dp[i][j]: i個目までの数字でjをいくつ作れるか
        long[][] dp = new long[n][21];
        dp[1][a[0]] = 1;
        for (int i = 2; i < n; i++) {
            for (int j = 0; j <= 20; j++) {
                // i番目を足すとき
                if (j <= 20 && j - a[i - 1] >= 0 && j - a[i - 1] <= 20) {
                    dp[i][j] += dp[i - 1][j - a[i - 1]];
                }
                // i番目を引くとき
                if (0 <= j && j + a[i - 1] >= 0 && j + a[i - 1] <= 20) {
                    dp[i][j] += dp[i - 1][j + a[i - 1]];
                }
            }
        }

        System.out.println(dp[n - 1][a[n - 1]]);
    }
}
