package selection._072;

import java.util.Scanner;

public class Main {
    static final long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        sc.close();

        long[] factorials = getFactorials();
        System.out.println(factorials[w + h - 2] * modInv(factorials[w - 1] * factorials[h - 1] % MOD, MOD) % MOD);
    }

    // 各階乗の値を求める
    static long[] getFactorials() {
        long[] result = new long[250001];
        result[0] = result[1] = 1;
        for (int i = 2; i <= 250000; i++) {
            result[i] = result[i - 1] * i % MOD;
        }

        return result;
    }

    // aの逆元をmod p のもとで求める
    static long modInv(long a, long p) {
        // a^(p-1) ≡ 1 (mod p) → a * a^(p-2) ≡ 1 (mod p)
        // 上記よりaの逆元はa^(p-2)に等しい事がわかる
        return modPow(a, p - 2, p);
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
