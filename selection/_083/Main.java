package selection._083;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] p = new int[m];
        long[] a = new long[n - 1];
        long[] b = new long[n - 1];
        long[] c = new long[n - 1];
        for (int i = 0; i < m; i++) {
            p[i] = sc.nextInt() - 1;
        }
        for (int i = 0; i < n - 1; i++) {
            a[i] = sc.nextLong();
            b[i] = sc.nextLong();
            c[i] = sc.nextLong();
        }
        sc.close();

        // 累積和
        // sum[i]: 鉄道iに乗車する合計回数
        int[] sum = new int[n + 1];
        for (int i = 0; i < m - 1; i++) {
            int start = p[i];
            int end = p[i + 1];
            if (start > end) {
                int tmp = start;
                start = end;
                end = tmp;
            }
            sum[start]++;
            sum[end]--;
        }
        for (int i = 1; i <= n; i++) {
            sum[i] += sum[i - 1];
        }

        long result = 0;
        for (int i = 0; i < n - 1; i++) {
            result += Math.min(a[i] * sum[i], b[i] * sum[i] + c[i]);
        }

        System.out.println(result);
    }
}
