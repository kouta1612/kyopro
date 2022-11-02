package selection._023;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
        }
        sc.close();

        int[] points = new int[(n + 1) * (n + 1)];
        int index = 0;
        // 制約が厳しくてSetとかArrayListとかのデータ構造使うとMLEになる
        // そのため配列で実装している
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                points[index] = p[i] + p[j];
                index++;
            }
        }

        Arrays.sort(points);

        int result = 0;
        for (int point : points) {
            // sum[i] + point <= m を満たす最大のi
            int ub = upper_bound(points, m - point);
            if (ub >= 0) {
                result = Math.max(result, point + points[ub]);
            }
        }

        System.out.println(result);
    }

    static int upper_bound(int[] a, int key) {
        int l = -1, r = a.length;
        while (r - l > 1) {
            int mid = (l + r) / 2;
            if (a[mid] <= key) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
