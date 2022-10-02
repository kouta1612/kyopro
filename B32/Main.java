package B32;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[k];
        for (int i = 0; i < k; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        boolean[] dp = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            boolean found = false;
            for (int j = 0; j < k; j++) {
                if (i - a[j] >= 0 && dp[i - a[j]] == false) {
                    found = true;
                }
            }
            dp[i] = found;
        }

        if (dp[n]) {
            System.out.println("First");
        } else {
            System.out.println("Second");
        }
    }
}
