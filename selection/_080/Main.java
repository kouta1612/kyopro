package selection._080;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        long k = sc.nextLong();
        long v = sc.nextLong();
        long[][] a = new long[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                a[i][j] = sc.nextLong();
            }
        }
        sc.close();

        // sum[i][j]: [0,i) ☓ [0,j) の長方形区間の和
        // 二次元累積和
        long[][] sum = new long[h + 1][w + 1];
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + a[i - 1][j - 1];
            }
        }

        long result = 0;
        // 左上の頂点
        for (int x1 = 0; x1 <= h; x1++) {
            for (int y1 = 0; y1 <= w; y1++) {
                // 右下の頂点
                for (int x2 = 0; x2 <= h; x2++) {
                    for (int y2 = 0; y2 <= w; y2++) {
                        if (!(x1 < x2 && y1 < y2)) {
                            continue;
                        }
                        long currentSum = sum[x2][y2] - sum[x2][y1] - sum[x1][y2] + sum[x1][y1];
                        long num = (x2 - x1) * (y2 - y1);
                        if (!(currentSum + num * k <= v)) {
                            continue;
                        }

                        result = Math.max(result, num);
                    }
                }
            }
        }

        System.out.println(result);
    }
}
