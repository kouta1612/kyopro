package A32;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        boolean[] dp = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i >= a && dp[i - a] == false) {
                dp[i] = true;
            } else if (i >= b && dp[i - b] == false) {
                dp[i] = true;
            } else {
                dp[i] = false;
            }
        }

        if (dp[n]) {
            System.out.println("First");
        } else {
            System.out.println("Second");
        }
    }
}
