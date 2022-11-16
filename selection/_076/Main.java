package selection._076;

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

        long[] sum = new long[n + 1];
        sum[1] = a[0];
        for (int i = 2; i <= n; i++) {
            sum[i] = sum[i - 1] + a[i - 1];
        }

        for (int l = 1; l <= n; l++) {
            long result = 0;
            for (int i = 0; i <= n - l; i++) {
                int j = i + l;
                result = Math.max(result, sum[j] - sum[i]);
            }
            System.out.println(result);
        }
    }
}
