package A07;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int n = sc.nextInt();
        int[] l = new int[n];
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
            r[i] = sc.nextInt();
        }

        // sum[i]: i日目までに出席した合計人数
        int[] sum = new int[d + 2];

        // i日目の前日比をとる
        for (int i = 0; i < n; i++) {
            sum[l[i]] += 1;
            sum[r[i] + 1] -= 1;
        }

        // 累積和をとる
        for (int i = 0; i < d; i++) {
            sum[i + 1] = sum[i] + sum[i + 1];
        }

        for (int i = 0; i < d; i++) {
            System.out.println(sum[i + 1]);
        }

        sc.close();
    }
}
