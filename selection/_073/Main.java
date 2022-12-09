package selection._073;

import java.util.Scanner;

public class Main {
    static final long MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.close();

        if ((x + y) % 3 != 0) {
            System.out.println(0);
            return;
        }

        // operations[i]: i=0の時はx, i=1の時はyの操作回数
        int[] operations = getOperations(x, y);
        if (!(operations[0] >= 0 && operations[1] >= 0)) {
            System.out.println(0);
            return;
        }

        long[] factorials = getFactorials();
        System.out.println(factorials[operations[0] + operations[1]] * modInv(factorials[operations[0]] * factorials[operations[1]] % MOD, MOD) % MOD);
    }

    static int[] getOperations(int x, int y) {
        int[] result = new int[2];
        result[0] = (2 * y - x) / 3;
        result[1] = y - 2 * result[0];

        return result;
    }

    // 各階乗の値を求める
    static long[] getFactorials() {
        long[] result = new long[1000001];
        result[0] = result[1] = 1;
        for (int i = 2; i <= 1000000; i++) {
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
