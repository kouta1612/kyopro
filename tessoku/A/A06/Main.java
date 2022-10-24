package A06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] a = new int[n];
        int[] l = new int[q];
        int[] r = new int[q];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < q; i++) {
            l[i] = sc.nextInt();
            r[i] = sc.nextInt();
        }

        // sum[i]: i日目までの総来場者数
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + a[i];
        }

        for (int i = 0; i < q; i++) {
            System.out.println(sum[r[i]] - sum[l[i] - 1]);
        }

        sc.close();
    }
}
