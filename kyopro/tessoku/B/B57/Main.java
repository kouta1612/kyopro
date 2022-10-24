package B57;

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();

        // dp[i][j]: 値iを2^j回操作したあとの値
        int[][] dp = new int[n + 1][30];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = i - ketawa(i);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < 30; j++) {
                dp[i][j] = dp[dp[i][j - 1]][j - 1];
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        for (int i = 1; i <= n; i++) {
            int current = i;
            for (int j = 0; j < 30; j++) {
                if ((k & (1 << j)) != 0) {
                    current = dp[current][j];
                }
            }
            out.println(current);
        }
        out.flush();
    }

    static int ketawa(int x) {
        int result = 0;
        while (x != 0) {
            result += x % 10;
            x /= 10;
        }

        return result;
    }
}
