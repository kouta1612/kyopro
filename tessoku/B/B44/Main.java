package B44;

import java.io.PrintWriter;
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
        int q = sc.nextInt();
        int[] row = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            row[i] = i;
        }
        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (type == 1) {
                int tmp = row[x];
                row[x] = row[y];
                row[y] = tmp;
            }
            if (type == 2) {
                out.println(a[row[x] - 1][y - 1]);
            }
        }
        sc.close();
        out.flush();
    }
}
