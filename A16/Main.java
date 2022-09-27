package A16;

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
        for (int i = 0; i < n - 2; i++) {
            b[i] = sc.nextInt();
        }

        // dp[i]: 足場1から足場iに移動する最小時間
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1 << 30);
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i], dp[i - 1] + a[i - 2]);
            if (i > 2) {
                dp[i] = Math.min(dp[i], dp[i - 2] + b[i - 3]);
            }
        }
        System.out.println(dp[n]);

        sc.close();
    }
}
