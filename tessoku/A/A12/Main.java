package A12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        // k枚目のチラシが何秒後にできるかを二分探索
        int l = 0, r = 1 << 30;
        while (r - l > 0) {
            int mid = (l + r) / 2;
            if (isCreated(k, mid, a)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(l);
    }

    static boolean isCreated(int k, int sec, long[] a) {
        long paperNum = 0;
        for (int i = 0; i < a.length; i++) {
            paperNum += sec / a[i];
        }

        return paperNum >= k;
    }
}
