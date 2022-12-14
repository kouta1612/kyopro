package selection._083;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] p = new int[m];
        long[] a = new long[n];
        long[] b = new long[n];
        long[] c = new long[n];
        for (int i = 0; i < m; i++) {
            p[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
            b[i] = sc.nextLong();
            c[i] = sc.nextLong();
        }
        sc.close();
    }
}
