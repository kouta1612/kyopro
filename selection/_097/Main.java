package selection._097;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong() / 2;
        }
        sc.close();

        long division = countDivisionsByTwo(a[0]);
        for (int i = 0; i < n; i++) {
            if (division != countDivisionsByTwo(a[i])) {
                System.out.println(0);
                return;
            }
            a[i] >>= division;
        }
        // これを忘れずに！
        m >>= division;

        long l = lcm(a[0], 1);
        if (l > m) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < n; i++) {
            l = lcm(l, a[i]);
            if (l > m) {
                System.out.println(0);
                return;
            }
        }

        long result = 0;
        for (long i = 1; i * l <= m; i += 2) {
            result++;
        }

        System.out.println(result);
    }

    static long countDivisionsByTwo(long a) {
        long result = 0;
        while (a % 2 == 0) {
            a /= 2;
            result++;
        }

        return result;
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
