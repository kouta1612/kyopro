package A30;

import java.util.Scanner;

public class Main {

    static long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long r = sc.nextLong();
        sc.close();

        System.out.println(combination(n, r));
    }

    // n! / (r! * (n - r)!) % MOD
    static long combination(long n, long r) {
        return division(factorial(n), factorial(r) * factorial(n - r) % MOD);
    }

    // a/b % MOD
    static long division(long a, long b) {
        return a * power(b, MOD - 2) % MOD;
    }

    // a! % MOD
    static long factorial(long a) {
        long result = 1;
        for (int i = 1; i <= a; i++) {
            result = (result * i) % MOD;
        }

        return result;
    }

    // a^b % MOD
    static long power(long a, long b) {
        long result = 1;
        for (int i = 0; i < 30; i++) {
            if ((b >> i) % 2 == 1) {
                result = (result * a) % MOD;
            }
            a = (a * a) % MOD;
        }

        return result;
    }
}
