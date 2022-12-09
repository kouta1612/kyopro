package lib.Factorize;

public class Main {
    static final long MOD = 1000000007;

    public static void main(String[] args) {
        long[] factorials = getFactorials(MOD);
        System.out.println(factorials[3]);
    }

    // 各階乗の値を求める
    static long[] getFactorials(long p) {
        long[] result = new long[1000001];
        result[0] = result[1] = 1;
        for (int i = 2; i <= 1000000; i++) {
            result[i] = result[i - 1] * i % p;
        }

        return result;
    }
}
