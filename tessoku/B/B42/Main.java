package B42;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        sc.close();

        long[] sum = new long[4];
        for (int i = 0; i < n; i++) {
            if (a[i] + b[i] > 0) {
                sum[0] += a[i] + b[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (a[i] - b[i] > 0) {
                sum[1] += a[i] - b[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (-a[i] + b[i] > 0) {
                sum[2] += -a[i] + b[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (-a[i] - b[i] > 0) {
                sum[3] += -a[i] - b[i];
            }
        }

        Arrays.sort(sum);
        System.out.println(sum[3]);
    }
}
