package selection._049;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int[] s = new int[e];
        int[] t = new int[e];
        int[] d = new int[e];
        for (int i = 0; i < e; i++) {
            s[i] = sc.nextInt();
            t[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }
        sc.close();

        // dp[i][j]: 集合iを通りj地点に至るまでの最短経路
        int[][] dp = new int[1 << v][v];
        for (int i = 0; i < 1 << v; i++) {
            for (int j = 0; j < v; j++) {
                dp[i][j] = 1 << 30;
            }
        }
        // 開始地点を0にする
        dp[0][0] = 0;

        for (int i = 1; i < 1 << v; i++) {
            // 出発点を列挙
            for (int j = 0; j < v; j++) {
                // 集合iに地点jが含まれていなければスキップ
                if ((i & (1 << j)) == 0) {
                    continue;
                }
                for (int k = 0; k < e; k++) {
                    if (t[k] != j) {
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i - (1 << j)][s[k]] + d[k]);
                }
            }
        }

        if (dp[(1 << v) - 1][0] == 1 << 30) {
            System.out.println(-1);
        } else {
            System.out.println(dp[(1 << v) - 1][0]);
        }
    }
}
