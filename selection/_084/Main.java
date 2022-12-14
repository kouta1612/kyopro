package selection._084;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 累積和
        int[][] sum = new int[n + 5][n + 5];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int x = sc.nextInt();
            sum[a][b] += 1;
            sum[a][b + 1] -= 1;
            sum[a + x + 1][b] -= 1;
            sum[a + x + 2][b + 1] += 1;
            sum[a + x + 1][b + x + 2] += 1;
            sum[a + x + 2][b + x + 2] -= 1;
        }
        sc.close();

        // 横方向の累積和
        for (int i = 0; i < n + 5; i++) {
            for (int j = 1; j < n + 5; j++) {
                sum[i][j] += sum[i][j - 1];
            }
        }
        // 縦方向の累積和
        for (int i = 0; i < n + 5; i++) {
            for (int j = 1; j < n + 5; j++) {
                sum[j][i] += sum[j - 1][i];
            }
        }
        // 斜め方向の累積和
        for (int i = 0; i < n + 5; i++) {
            for (int j = 1; i + j < n + 5; j++) {
                sum[i + j][j] += sum[i + j - 1][j - 1];
            }
        }

        long result = 0;
        for (int i = 0; i < n + 5; i++) {
            for (int j = 0; j < n + 5; j++) {
                if (sum[i][j] >= 1) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
