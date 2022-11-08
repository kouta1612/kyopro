package selection._040;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[k];
        int[] b = new int[k];
        for (int i = 0; i < k; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        sc.close();

        // dp[i][j][k]: i日目までのパスタの選び方で、i-1日目のパスタがj、i-2日目のパスタがkであるようなものの総数
        int[][][] dp = new int[n + 1][4][4];

    }
}
