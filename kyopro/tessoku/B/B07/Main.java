package B07;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();
        int[] l = new int[n];
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
            r[i] = sc.nextInt();
        }

        // sum[i]: 時刻iに従業員が何人いるか
        int[] sum = new int[t + 2];
        for (int i = 0; i < n; i++) {
            sum[l[i]] += 1;
            // 出力時の+0.5hを勘案すると時刻r[i]には従業員が存在しなくなることに注意
            sum[r[i]] -= 1;
        }

        // 累積和
        for (int i = 0; i < t; i++) {
            sum[i + 1] += sum[i];
        }

        for (int i = 0; i < t; i++) {
            System.out.println(sum[i]);
        }

        sc.close();
    }
}
