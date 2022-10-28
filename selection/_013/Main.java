package selection._013;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[][] a = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        sc.close();

        int result = 0;
        for (int i = 0; i < 1 << x; i++) {
            int[][] b = getDeepCopy(a, x, y);

            // j行目の煎餅をすべてひっくり返す
            for (int j = 0; j < x; j++) {
                if ((i >> j) % 2 == 1) {
                    for (int j2 = 0; j2 < y; j2++) {
                        b[j][j2] = 1 - b[j][j2];
                    }
                }
            }

            // j列目の表の煎餅の数を数える
            int[] sum = new int[y];
            for (int j = 0; j < y; j++) {
                for (int j2 = 0; j2 < x; j2++) {
                    if (b[j2][j] == 1) {
                        sum[j]++;
                    }
                }
            }

            // j列目の煎餅の半数より多くが表になっていたらj列目をすべてひっくり返す
            for (int j = 0; j < y; j++) {
                if (x / 2 < sum[j]) {
                    for (int j2 = 0; j2 < x; j2++) {
                        b[j2][j] = 1 - b[j2][j];
                    }
                }
            }

            int current = 0;
            for (int j = 0; j < x; j++) {
                for (int j2 = 0; j2 < y; j2++) {
                    if (b[j][j2] == 0) {
                        current++;
                    }
                }
            }

            result = Math.max(result, current);
        }

        System.out.println(result);
    }

    static int[][] getDeepCopy(int[][] a, int x, int y) {
        int[][] result = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                result[i][j] = a[i][j];
            }
        }

        return result;
    }
}
