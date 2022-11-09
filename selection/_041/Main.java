package selection._041;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int n = sc.nextInt();
        int[] t = new int[d];
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < d; i++) {
            t[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }
        sc.close();

        // dp[i][j]: i日目にj番目の服を選んだときのi日目までの最大値
        int[][] dp = new int[d + 1][n + 1];
        for (int i = 2; i <= d; i++) {
            // i日目に着る服
            for (int j = 1; j <= n; j++) {
                // i - 1日目に着る服
                for (int j2 = 1; j2 <= n; j2++) {
                    // i日目に着る服が気温の条件を満たすか
                    if (!(a[j - 1] <= t[i - 1] && t[i - 1] <= b[j - 1])) {
                        continue;
                    }
                    // i - 1日目に着る服が気温の条件を満たすか
                    if (!(a[j2 - 1] <= t[i - 2] && t[i - 2] <= b[j2 - 1])) {
                        continue;
                    }
                    dp[i][j] = Math.max(dp[i - 1][j2] + Math.abs(c[j - 1] - c[j2 - 1]), dp[i][j]);
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, dp[d][i]);
        }

        System.out.println(result);
    }
}
