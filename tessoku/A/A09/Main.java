package A09;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }
        sc.close();

        int[][] result = new int[h + 1][w + 1];
        for (int i = 0; i < n; i++) {
            result[a[i]][b[i]]++;
            if (c[i] + 1 <= h && d[i] + 1 <= w) {
                result[c[i] + 1][d[i] + 1]++;
            }
            if (c[i] + 1 <= h) {
                result[c[i] + 1][b[i]]--;
            }
            if (d[i] + 1 <= w) {
                result[a[i]][d[i] + 1]--;
            }
        }

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                result[i][j] += result[i][j - 1];
            }
        }

        for (int i = 1; i <= w; i++) {
            for (int j = 1; j <= h; j++) {
                result[j][i] += result[j - 1][i];
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                builder.append(result[i][j] + " ");
            }
            builder.append("\n");
        }

        System.out.println(builder.toString().trim());
    }
}
