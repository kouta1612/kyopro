package A08;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int[][] x = new int[h + 2][w + 2];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                x[i][j] = sc.nextInt();
            }
        }

        int q = sc.nextInt();
        int[] a = new int[q];
        int[] b = new int[q];
        int[] c = new int[q];
        int[] d = new int[q];
        for (int i = 0; i < q; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }

        // sum[i][j]: x[1-i][1-j]の総和
        int[][] sum = new int[h + 2][w + 2];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + x[i][j];
            }
        }

        // デバッグ
        // for (int i = 1; i <= h; i++) {
        // for (int j = 1; j <= w; j++) {
        // System.out.printf("%02d ", sum[i][j]);
        // }
        // System.out.println("");
        // }

        for (int i = 0; i < q; i++) {
            System.out.println(sum[c[i]][d[i]] - sum[a[i] - 1][d[i]] - sum[c[i]][b[i] - 1] + sum[a[i] - 1][b[i] - 1]);
        }

        sc.close();
    }
}