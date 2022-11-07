package selection._038;

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0; i < q; i++) {
            String s = sc.next();
            String t = sc.next();

            int[][] dp = new int[s.length() + 1][t.length() + 1];
            for (int j = 1; j <= s.length(); j++) {
                for (int j2 = 1; j2 <= t.length(); j2++) {
                    if (s.charAt(j - 1) == t.charAt(j2 - 1)) {
                        dp[j][j2] = Math.max(dp[j - 1][j2 - 1] + 1, dp[j][j2]);
                    } else {
                        dp[j][j2] = Math.max(dp[j][j2 - 1], dp[j - 1][j2]);
                    }
                }
            }

            out.println(dp[s.length()][t.length()]);
        }
        sc.close();
        out.flush();
    }
}
