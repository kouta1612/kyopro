package A22;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n - 1; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            b[i] = sc.nextInt();
        }

        // dp[i]: マス1からマスiにたどりつくまでに得られる合計スコアのうち最大のもの
        long[] dp = new long[n + 1];
        // Nに到達しないことを考える必要がある
        Arrays.fill(dp, -150);
        dp[0] = dp[1] = 0;
        for (int i = 1; i < n; i++) {
            dp[a[i - 1]] = Math.max(dp[a[i - 1]], dp[i] + 100);
            dp[b[i - 1]] = Math.max(dp[b[i - 1]], dp[i] + 150);
        }

        System.out.println(dp[n]);

        sc.close();
    }
}
