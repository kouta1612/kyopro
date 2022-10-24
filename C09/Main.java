package C09;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        sc.close();

        // dp1[i]: i日目に勉強する場合のi日目までの実力アップの最大値
        // dp2[i]: i日目に勉強しない場合のi日目までの実力アップの最大値
        long[] dp1 = new long[n + 1];
        long[] dp2 = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            dp1[i] = dp2[i - 1] + a[i - 1];
            dp2[i] = Math.max(dp2[i - 1], dp1[i - 1]);
        }

        System.out.println(Math.max(dp1[n], dp2[n]));
    }
}
