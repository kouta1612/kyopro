package A44;

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }

        int q = sc.nextInt();
        int state = 0;
        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                if (state == 0) {
                    a[x - 1] = y;
                }
                if (state == 1) {
                    a[n - x] = y;
                }
            }
            if (type == 2) {
                state ^= 1;
            }
            if (type == 3) {
                int x = sc.nextInt();
                if (state == 0) {
                    out.println(a[x - 1]);
                }
                if (state == 1) {
                    out.println(a[n - x]);
                }
            }
        }
        sc.close();

        out.flush();
    }
}
