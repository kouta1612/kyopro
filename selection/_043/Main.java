package selection._043;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] s = new String[5][n];
        for (int i = 0; i < 5; i++) {
            s[i] = sc.next().split("");
        }
        sc.close();

        // dp[i][j]: i列目を色jで塗り終えた時までに必要な塗り替える色の個数の最小
        int[][] dp = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 2; j++) {
                dp[i][j] = 1<<30;
            }
        }
        for (int i = 1; i <= n; i++) {
            // i列目の色を列挙
            // 0 => 赤, 1 => 青, 2 => 白
            for (int j = 0; j < 3; j++) {
                // i列目を色jで塗り替えた個数をカウント
                int count = 0;
                for (int k = 0; k < 5; k++) {
                    if ((j == 0 && !s[k][i - 1].equals("R")) || (j == 1 && !s[k][i - 1].equals("B")) || (j == 2 && !s[k][i - 1].equals("W"))) {
                        count++;
                    }
                }
                if (i == 1) {
                    dp[1][j] = count;
                } else {
                    // i-1列目の色を列挙
                    for (int k = 0; k < 3; k++) {
                        // i-1列目の色と同じ場合はスキップ
                        if (j == k) {
                            continue;
                        }
                        dp[i][j] = Math.min(dp[i - 1][k] + count, dp[i][j]);
                    }
                }
            }
        }

        int result = 1<<30;
        for (int i = 0; i < 3; i++) {
            result = Math.min(result, dp[n][i]);
        }

        System.out.println(result);
    }
}
