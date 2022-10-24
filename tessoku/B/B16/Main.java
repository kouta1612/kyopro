package B16;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }

        // 足場1から足場iへたどり着くまでの最小コスト
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1 << 30);
        dp[0] = dp[1] = 0;
        dp[2] = Math.abs(h[1] - h[0]);
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + Math.abs(h[i - 1] - h[i - 2]), dp[i - 2] + Math.abs(h[i - 1] - h[i - 3]));
        }
        System.out.println(dp[n]);

        sc.close();
    }
}
