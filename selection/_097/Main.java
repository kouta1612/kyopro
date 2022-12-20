package selection._097;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        sc.close();

        if (n == 1) {
            long result = 0;
            for (long i = a[0] / 2; i <= m; i += a[0]) {
                result++;
            }
            System.out.println(result);
            return;
        }

        long x = lcm(a[0], a[1]);
        long y = lcm(a[0] / 2, a[1] / 2);
        for (int i = 2; i < n; i++) {
            x = lcm(x, a[i]);
            y = lcm(y, a[i] / 2);
        }

        long result = 0;
        for (long i = y; i <= m; i += x) {
            result++;
        }

        System.out.println(result);
    }

    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}
