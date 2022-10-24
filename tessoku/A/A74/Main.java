package A74;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        sc.close();

        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != 0) {
                    x[i] = a[i][j];
                }
                if (a[j][i] != 0) {
                    y[i] = a[j][i];
                }
            }
        }

        int resultX = 0;
        int resultY = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (x[i] > x[j]) {
                    resultX++;
                }
                if (y[i] > y[j]) {
                    resultY++;
                }
            }
        }

        System.out.println(resultX + resultY);
    }
}
