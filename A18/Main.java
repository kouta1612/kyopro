package A18;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // dp[i][j]: i枚のカードの中からいくつか選んで、書かれた整数の合計がjになるかどうか
        boolean[][] dp = new boolean[n + 1][s + 1];
        for (boolean[] item : dp) {
            Arrays.fill(item, false);
        }

        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= s; j++) {
                // 選ばない場合
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                }
                // 選ぶ場合
                if (dp[i - 1][j] || (j - a[i - 1] >= 0 && dp[i - 1][j - a[i - 1]])) {
                    dp[i][j] = true;
                }
            }
        }

        // System.out.println(Arrays.deepToString(dp));
        for (int i = 1; i <= n; i++) {
            if (dp[i][s]) {
                System.out.println("Yes");
                sc.close();
                return;
            }
        }

        System.out.println("No");

        sc.close();
    }
}
