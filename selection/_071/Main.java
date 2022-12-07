package selection._071;

import java.util.Scanner;

public class Main {
    static final long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        long[] a = new long[n];
        int[] c = new int[q];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        for (int i = 0; i < q; i++) {
            c[i] = sc.nextInt();
        }
        sc.close();

        // 累積和
        long[] sum = new long[n + 1];

        // 累積和でMODを取るとWAでるので注意
        for (int i = 2; i <= n; i++) {
            sum[i] = (sum[i - 1] + modPow(a[i - 2], a[i - 1], MOD));
        }

        long result = 0;
        result = (result + sum[c[0]]) % MOD;
        result = (result + sum[c[q - 1]]) % MOD;
        for (int i = 1; i < q; i++) {
            result = (result + (Math.abs(sum[c[i]] - sum[c[i - 1]]) % MOD)) % MOD;
        }

        System.out.println(result);
    }

    static long modPow(long a, long n, long p) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return a;
        }
        if (n % 2 == 1) {
            return (a * modPow(a, n - 1, p)) % p;
        }

        long t = modPow(a, n / 2, p);
        return t * t % p;
    }
}
