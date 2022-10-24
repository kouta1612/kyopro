package A37;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long b = sc.nextLong();
        long[] a = new long[n];
        long[] c = new long[m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        for (int i = 0; i < m; i++) {
            c[i] = sc.nextLong();
        }
        sc.close();

        long sumA = 0;
        for (int i = 0; i < n; i++) {
            sumA += a[i];
        }
        long sumC = 0;
        for (int i = 0; i < m; i++) {
            sumC += c[i];
        }

        long result = n * sumC + b * n * m + m * sumA;

        System.out.println(result);
    }
}
