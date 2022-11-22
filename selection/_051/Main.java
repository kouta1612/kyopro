package selection._051;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        sc.close();

        // dp[i][j]: i日目に参加した部員がjの時のスケジュール表の組み合わせ
        int[][] dp = new int[n + 1][8];

        Map<Character, Integer> map = new HashMap<>();
        map.put('J', 1);
        map.put('O', 2);
        map.put('I', 4);

        // 事前準備
        dp[1][map.get(s.charAt(0))] = 1;

        for (int i = 1; i < n; i++) {
            // i日目の部員の集合
            for (int j = 1; j <= 7; j++) {
                // i日目の責任者
                int e = map.get(s.charAt(i - 1));

                // i日目に責任者が含まれていなかったらスキップ
                if ((j & e) == 0) {
                    continue;
                }

                // i + 1日目の部員の集合
                for (int k = 1; k <= 7; k++) {
                    // 責任者がいなければスキップ
                    if ((k & map.get(s.charAt(i))) == 0) {
                        continue;
                    }
                    // i日目の部員の集合がi + 1日目の部員の集合と共通部分を持たない場合スキップ
                    if ((k & j) == 0) {
                        continue;
                    }

                    dp[i + 1][k] += dp[i][j];
                    dp[i + 1][k] %= 10007;
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
    }
}
