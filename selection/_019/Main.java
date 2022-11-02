package selection._019;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] shopPoints = new int[n + 1];
        int[] orderPoints = new int[m];

        shopPoints[n] = d;
        for (int i = 1; i < n; i++) {
            shopPoints[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            orderPoints[i] = sc.nextInt();
        }

        sc.close();

        Arrays.sort(shopPoints);

        int result = 0;
        for (int i = 0; i < m; i++) {
            int lb = lower_bound(shopPoints, orderPoints[i]);
            int dist = Math.abs(shopPoints[lb] - orderPoints[i]);
            if (lb - 1 >= 0) {
                dist = Math.min(dist, Math.abs(shopPoints[lb - 1] - orderPoints[i]));
            }
            result += dist;
        }

        System.out.println(result);
    }

    static int lower_bound(int[] a, int key) {
        int l = -1, r = a.length;
        // 条件を満たすかどうかの堺目が分かる状態になるのはl + 1 = rの状態
        while (r - l > 1) {
            int mid = (l + r) / 2;
            if (a[mid] >= key) {
                r = mid;
            } else {
                l = mid;
            }
        }

        return r;
    }
}
