package A75;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[n];
        int[] d = new int[n];
        ArrayList<Pair> q = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            d[i] = sc.nextInt();
            q.add(new Pair(t[i], d[i]));
        }
        sc.close();

        Collections.sort(q, new Comparator<Pair>() {
            public int compare(Pair o1, Pair o2) {
                if (o1.limit > o2.limit) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        // dp[i][j]: i問目までの中からいくつか選んで開始時刻からj分かかっている時の最大正解数
        int[][] dp = new int[n + 1][1441];
        for (int i = 1; i <= n; i++) {
            // 今取り組むべきか考えている問題
            Pair p = q.get(i - 1);
            // 今の問題に取り組む前までにかかっている時間
            for (int j = 0; j <= 1440; j++) {
                // 選ぶ時
                if (j - p.minute >= 0 && j <= p.limit) {
                    dp[i][j] = Math.max(dp[i - 1][j - p.minute] + 1, dp[i - 1][j]);
                } else {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
            }
        }

        int result = 0;
        for (int i = 0; i <= 1440; i++) {
            result = Math.max(result, dp[n][i]);
        }

        System.out.println(result);
    }
}

class Pair {
    int minute;
    int limit;

    Pair(int minute, int limit) {
        this.minute = minute;
        this.limit = limit;
    }
}