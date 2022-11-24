package selection._054;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        int currentMax = 0;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (currentMax < a[i - 1]) {
                currentMax = a[i - 1];
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }

        System.out.println(dp[n]);
    }
}
