package selection._004;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[][] a = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextLong();
            }
        }
        sc.close();

        long result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (i == j) {
                    continue;
                }
                long current = 0;
                for (int k = 0; k < n; k++) {
                    current += Math.max(a[k][i], a[k][j]);
                }
                result = Math.max(result, current);
            }
        }

        System.out.println(result);
    }
}
