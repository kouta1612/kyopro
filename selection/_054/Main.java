package selection._054;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        LIS lis = new LIS(a);

        System.out.println(n - lis.getLIS());
    }

    /**
     * ある条件(a[i] < x)を満たす最大のiを求める
     *
     * @param a
     * @param key
     * @return
     */
    static int upper_bound(int[] a, int key) {
        int l = -1, r = a.length;
        while (r - l > 1) {
            int mid = (l + r) / 2;
            if (a[mid] < key) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return l;
    }
}

class LIS {
    int[] a;
    int[] dp;
    int[] len;

    LIS(int[] a) {
        this.a = a;
    }

    int getLIS() {
        build();

        int result = 0;
        for (int i = 1; i <= a.length; i++) {
            result = Math.max(result, dp[i]);
        }

        return result;
    }

    void build() {
        int n = a.length;
        // dp[i]: 最後の要素がa[i]である部分列のうちで考えられる部分列の最長の長さ
        dp = new int[n + 1];
        // len[i]: 長さがiの部分列の最後の要素として考えられる要素の最小値
        len = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            len[i] = 1<<30;
        }
        dp[1] = 1;
        len[0] = -1<<30;

        for (int i = 1; i <= n; i++) {
            // len[0] = -1<<30なのでpos >= 0であることが保証される
            int pos = upper_bound(len, a[i - 1]);
            dp[i] = pos + 1;
            len[dp[i]] = a[i - 1];
        }
    }

    /**
     * ある条件(a[i] < x)を満たす最大のiを求める
     *
     * @param a
     * @param key
     * @return
     */
    int upper_bound(int[] a, int key) {
        int l = -1, r = a.length;
        while (r - l > 1) {
            int mid = (l + r) / 2;
            if (a[mid] < key) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return l;
    }
}