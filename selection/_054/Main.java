package selection._054;

import java.util.Arrays;
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

        // dp[i]: 最後の要素がa[i]である部分列のうちで考えられる部分列の最長の長さ
        int[] dp = new int[n + 1];
        // len[i]: 長さがiの部分列の最後の要素として考えられる要素の最小値
        int[] len = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            len[i] = 1<<30;
        }
        dp[1] = 1;
        len[0] = -1<<30;

        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(len));
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
