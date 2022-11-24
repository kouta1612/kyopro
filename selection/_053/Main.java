package selection._053;

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

        // dp[i]: i番目までの部分列の中で最後の要素がa[i - 1]のうちで、最長の部分列の長さ
        int[] dp = new int[n + 1];
        // len[i]: 長さiの部分文字列のうち最後の要素の値が最小のもの
        int[] len = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = len[i] = 1 << 30;
        }
        dp[0] = 0;
        len[0] = 0;

        for (int i = 1; i <= n; i++) {
            int pos = upper_bound(len, a[i - 1]);
            if (pos == -1) {
                dp[i] = 1;
            } else {
                dp[i] = Math.min(dp[i], pos + 1);
            }
            len[dp[i]] = a[i - 1];
        }

        int result = 0;
        for (int i = 0; i <= n; i++) {
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
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
