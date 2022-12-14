package selection._020;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(a);
        Arrays.sort(c);

        long result = 0;
        for (int i = 0; i < n; i++) {
            long ub = upper_bound(a, b[i]);
            long lb = lower_bound(c, b[i]);
            result += (ub + 1) * (n - lb);
        }

        System.out.println(result);
    }

    static int lower_bound(int[] a, int key) {
        int l = -1, r = a.length;
        while (r - l > 1) {
            int mid = (l + r) / 2;
            if (a[mid] > key) {
                r = mid;
            } else {
                l = mid;
            }
        }

        return r;
    }

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
