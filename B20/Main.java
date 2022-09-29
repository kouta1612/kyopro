package B20;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        int sLen = s.length();
        int tLen = t.length();

        // dp[i][j]: sのi文字目までとtのj文字目までの文字列において一致するまでの最小回数
        int[][] dp = new int[sLen + 1][tLen + 1];

        // 前処理
        for (int i = 0; i <= sLen; i++) {
            for (int j = 0; j <= tLen; j++) {
                dp[i][j] = 1 << 15;
            }
        }
        dp[0][0] = 0;
        for (int i = 1; i <= sLen; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= tLen; i++) {
            dp[0][i] = i;
        }

        // 動的計画法
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1]));
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }

        System.out.println(dp[sLen][tLen]);

        sc.close();
    }
}
