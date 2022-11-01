package selection._020;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] h = new long[n];
        long[] s = new long[n];
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextLong();
            s[i] = sc.nextLong();
        }
        sc.close();

        long l = -1, r = 1L<<60;
        long mid = (l + r) / 2;
        while (r - l > 1) {
            mid = (l + r) / 2;
            if (check(mid, h, s)) {
                r = mid;
            } else {
                l = mid;
            }
        }

        System.out.println(r);
    }

    // 高度の上限xでシミュレーションして全ての風船を割ることができるか
    static boolean check(long x, long[] h, long[] s) {
        // 各風船を何秒以内に割る必要があるかを前計算する
        long[] limit = new long[h.length];
        boolean ok = true;
        for (int i = 0; i < limit.length; i++) {
            limit[i] = (x - h[i]) / s[i];
            // そもそも初期の高度が上限よりも高かったらダメ（ここの条件忘れてた）
            if (h[i] > x) {
                ok = false;
            }
        }

        Arrays.sort(limit);

        for (int i = 0; i < limit.length; i++) {
            if (limit[i] < i) {
                ok = false;
            }
        }

        return ok;
    }
}
