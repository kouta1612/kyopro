package A11;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        // 標準APIを使った場合
        // System.out.println(Arrays.binarySearch(a, x) + 1);

        // 自作関数を使った場合
        System.out.println(binarySearch(a, x) + 1);

        sc.close();
    }

    static int binarySearch(int[] a, int x) {
        // l: 目的の値以下、r: 目的の値より大きい値を示すインデックス値となるように実装
        int l = 0, r = a.length;
        while (r - l > 1) {
            int mid = (r + l) / 2;
            if (x >= a[mid]) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return l;
    }

}
