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

        int[] dp = new int[n + 1];
        int[] len = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = len[i] = 1 << 30;
        }
        dp[0] = 0;
        len[0] = 0;

        for (int i = 1; i <= n; i++) {
            int pos = upper_bound(len, a[i - 1]);
            dp[i] = Math.min(dp[i], pos + 1);
            len[dp[i]] = a[i - 1];
        }

        System.out.println(dp[n]);
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
