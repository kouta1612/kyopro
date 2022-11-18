package selection._048;

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
            }

            // dp[i][j]: 区間[i,j]における取り除くことができるダルマの最大数
            int[][] dp = new int[n + 1][n + 1];

            // 長さ2のものを事前に列挙して更新
            for (int i = 1; i <= n - 1; i++) {
                if (Math.abs(a[i] - a[i + 1]) <= 1) {
                    dp[i][i + 1] = 2;
                }
            }

            for (int l = 2; l <= n; l++) {
                // 上端を列挙
                for (int i = 1; i <= n - l + 1; i++) {
                    // 下端を求める
                    int j = i + l - 1;

                    // 区間[i,j]がすべて取り除けたらその長さ分だけ最大値を更新
                    if (dp[i + 1][j - 1] == j - i - 1 && Math.abs(a[i] - a[j]) <= 1) {
                        dp[i][j] = Math.max(dp[i][j], j - i + 1);
                    }
                    // 区間[i,j]から区間を2つに分けた時の総和を列挙
                    for (int k = i; k <= j - 1; k++) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k + 1][j]);
                    }
                }
            }

            out.println(dp[1][n]);
        }

        out.flush();
        sc.close();
    }
}
