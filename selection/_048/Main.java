package selection._048;

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            // dp[i][j]: 区間[i,j]における取り除くことができるダルマの最大数
            int[][] dp = new int[n + 1][n + 1];


        }

        out.flush();
        sc.close();
    }
}
