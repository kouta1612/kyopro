package A65;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            // 社員iの直属の上司の社員番号
            a[i] = sc.nextInt();
        }
        sc.close();

        // dp[i]: 社員iの部下の数
        int[] dp = new int[n + 1];
        for (int i = n; i >= 1; i--) {
            dp[a[i]] += dp[i] + 1;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            builder.append(dp[i] + " ");
        }

        System.out.println(builder.toString().trim());
    }
}
