package B30;

import java.util.Scanner;

public class Main {

    static long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        sc.close();

        System.out.println(division(factorial((h - 1) + (w - 1)), factorial(h - 1) * factorial(w - 1) % MOD) % MOD);
    }

    static long factorial(long a) {
        long result = 1;
        for (int i = 1; i <= a; i++) {
            result = result * i % MOD;
        }

        return result;
    }

    static long division(long a, long b) {
        return a * power(b, MOD - 2) % MOD;
    }

    static long power(long a, long b) {
        long result = 1;
        for (int i = 0; i < 30; i++) {
            if ((b >> i) % 2 == 1) {
                result = result * a % MOD;
            }
            a = a * a % MOD;
        }

        return result;
    }
}
