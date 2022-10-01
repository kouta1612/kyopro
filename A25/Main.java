package A25;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        char[][] c = new char[h][w];
        for (int i = 0; i < h; i++) {
            String line = sc.next();
            for (int j = 0; j < w; j++) {
                c[i][j] = line.charAt(j);
            }
        }

        // dp[i][j]: マス(1,1)からマス(i,j)まで行く方法は何通りあるか
        long dp[][] = new long[h + 1][w + 1];
        dp[1][1] = 1;
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                if (c[i - 1][j - 1] == '.') {
                    if (i > 1 && j > 1) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    } else if (i == 1 && j > 1) {
                        dp[i][j] = dp[i][j - 1];
                    } else if (i > 1 && j == 1) {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        System.out.println(dp[h][w]);

        sc.close();
    }
}
