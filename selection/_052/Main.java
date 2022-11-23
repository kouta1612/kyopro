package selection._052;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // i種類目のぬいぐるみの個数
        int[] count = new int[m];
        // i種類目のぬいぐるみがj番目までで何個あるか
        int[][] sum = new int[m][n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt() - 1;
            count[a]++;
            sum[a][i]++;
        }
        sc.close();

        // 累積和
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= n - 2; j++) {
                sum[i][j + 1] += sum[i][j];
            }
        }

        // dp[i]: ぬいぐるみの種類の集合iのうち並べ替えのために取り出した個数の最小値
        int[] dp = new int[1 << m];
        for (int i = 0; i < 1 << m; i++) {
            dp[i] = 1 << 30;
        }
        dp[0] = 0;

        for (int i = 0; i < 1 << m; i++) {
            // 既に確定している配置の数を計算
            int done = 0;
            for (int j = 0; j < m; j++) {
                if ((i & (1 << j)) == 0) {
                    continue;
                }
                done += count[j];
            }

            // 次に配置するぬいぐるみの種類
            for (int j = 0; j < m; j++) {
                if ((i & (1 << j)) > 0) {
                    continue;
                }

                // 次の状態へ遷移するときのコストを計算
                int diff = 0;
                if (done > 0) {
                    diff += count[j] - (sum[j][done + count[j] - 1] - sum[j][done - 1]);
                } else {
                    diff += count[j] - sum[j][done + count[j] - 1];
                }
                // 配るDP
                dp[i | (1 << j)] = Math.min(dp[i | (1 << j)], dp[i] + diff);
            }
        }

        System.out.println(dp[(1 << m) - 1]);
    }
}
