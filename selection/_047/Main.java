package selection._047;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[2 * n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = a[i + n] = sc.nextLong();
        }
        sc.close();

        // dp[i][j]: 区間[i,j]におけるJOIくんの取りうる最大値
        long[][] dp = new long[2 * n + 1][2 * n + 1];

        // 区間の長さが1の場合は別で処理
        for (int i = 1; i <= 2 * n; i++) {
            if (n % 2 == 1) {
                dp[i][i] = a[i];
            }
        }

        // 区間の取りうる長さ
        for (int l = 2; l <= n; l++) {
            // 区間の左端
            for (int i = 1; i <= 2 * n - l + 1; i++) {
                // 区間の右端
                int j = i + l - 1;

                // JOIの番
                if (n % 2 == l % 2) {
                    dp[i][j] = Math.max(dp[i + 1][j] + a[i], dp[i][j - 1] + a[j]);
                } else {
                    if (a[i] > a[j]) {
                        dp[i][j] = dp[i + 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }

        long result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, dp[i][n + i - 1]);
        }

        System.out.println(result);
    }
}
