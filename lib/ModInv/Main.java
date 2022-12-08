package lib.ModInv;

public class Main {
    public static void main(String[] args) {
        System.out.println(modInv(20, 1000000007));
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
