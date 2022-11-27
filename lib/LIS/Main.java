package lib.LIS;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LIS lis = new LIS(new int[] { 10, 100, 1000 });
        System.out.println(lis.getLIS());
    }
}

/**
 * LIS(Longest Increasing Subsequence)(最長増加部分列)を構築
 */
class LIS {
    int[] a;

    LIS(int[] a) {
        this.a = a;
    }

    /**
     * 最長増加部分列の長さを取得
     *
     * @return
     */
    int getLIS() {
        int[] lis = build();

        // 「a[i] >= INFとなる最小のi」に対して「i - 1」が答え
        return lower_bound(lis, 1 << 30) - 1;
    }

    /**
     * 最長増加部分列を構築
     */
    int[] build() {
        int n = a.length;

        // dp[i]: 長さがiの単調増加な部分列における最終要素の最小値
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1 << 30);
        // a[i]が非常に小さい場合を考慮
        dp[0] = 0;

        // dp[j] >= a[i]となる最小のj(pos)を取得して、dp[pos]をa[i]で更新
        for (int i = 0; i < n; i++) {
            int pos = lower_bound(dp, a[i]);
            dp[pos] = a[i];
        }

        return dp;
    }

    /**
     * a[index] >= key という条件を満たす最小の index を求める
     *
     * @param a
     * @param key
     * @return
     */
    static int lower_bound(int[] a, int key) {
        int left = -1; // 「index = 0」が条件を満たすこともあるので、初期値は -1
        int right = a.length; // 「index = a.length-1」が条件を満たさないこともあるので、初期値は a.length

        // left は「常に」条件を満たさず、right は「常に」条件を満たすよう更新
        while (right - left > 1) {
            int mid = (left + right) / 2;

            if (a[mid] >= key) {
                right = mid;
            } else {
                left = mid;
            }
        }

        // left は条件を満たさない最大の値、right は条件を満たす最小の値になっている
        return right;
    }
}