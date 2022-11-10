package selection._042;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        sc.close();

        // dp[i][j]: i日目までに都市jに移動するまでに溜まる疲労度の最小値
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = 1<<30;
            }
        }
        // 都市0にいる時点で移動していないので、いつの時点でも疲労度0で初期化
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1] + a[j - 1] * b[i - 1], dp[i - 1][j]);
            }
        }

        System.out.println(dp[m][n]);
    }
}
