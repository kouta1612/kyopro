package selection._050;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        @SuppressWarnings("unchecked")
        List<Edge>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            // 0-indexedに修正
            int s = sc.nextInt() - 1;
            int t = sc.nextInt() - 1;
            long d = sc.nextLong();
            long limit = sc.nextLong();
            g[s].add(new Edge(t, d, limit));
            g[t].add(new Edge(s, d, limit));
        }
        sc.close();

        // dp[i][j]: 集合iをたどりjに到着した時点での最短距離とその方法の総数
        Result[][] dp = new Result[1 << n][n];
        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new Result(1L << 60, 0);
            }
        }
        dp[0][0] = new Result(0, 1);

        for (int i = 0; i < 1 << n; i++) {
            // 出発点を列挙
            for (int j = 0; j < n; j++) {
                // 集合iに地点jが含まれていなければスキップ
                if (i != 0 && (i & (1 << j)) == 0) {
                    continue;
                }

                Result current = dp[i][j];
                // 到着点を列挙
                for (Edge e : g[j]) {
                    // 制限時間を満たさなければスキップ
                    if (current.dist + e.dist > e.limit) {
                        continue;
                    }

                    // 既に通っていたらスキップ
                    if ((i & (1<<e.to)) > 0) {
                        continue;
                    }

                    // 到着点に記録した状態を復元
                    Result next = dp[i | (1 << e.to)][e.to];

                    // 過去に記録した到着点の最短距離と現在の出発点の最短距離から辿れる到着点の合計が同じであれば経路を加算する
                    if (next.dist == current.dist + e.dist) {
                        dp[i + (1 << e.to)][e.to] = new Result(next.dist, next.num + 1);
                    }

                    // 過去に記録した最短距離よりも小さかったら新しく更新する
                    if (next.dist > current.dist + e.dist) {
                        dp[i + (1 << e.to)][e.to] = new Result(current.dist + e.dist, 1);
                    }
                }
            }
        }

        Result result = dp[(1 << n) - 1][0];
        if (result.dist == 1L << 60) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result.dist + " " + result.num);
        }
    }
}

class Edge {
    int to;
    long dist, limit;

    Edge(int to, long dist, long limit) {
        this.to = to;
        this.dist = dist;
        this.limit = limit;
    }
}

class Result {
    long dist, num;

    Result(long dist, long num) {
        this.dist = dist;
        this.num = num;
    }
}