package selection._077;

import java.util.Scanner;

public class Main {
    static final int MOD = 100000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 累積和
        int[] sum = new int[n + 1];
        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            sum[i + 1] = sum[i] + a;
        }

        int nowPoint = 1;
        int result = 0;
        for (int i = 0; i < m; i++) {
            int migrate = sc.nextInt();
            int nextPoint = nowPoint + migrate;
            if (nowPoint < nextPoint) {
                result = (result + sum[nextPoint] - sum[nowPoint]) % MOD;
            } else {
                result = (result + sum[nowPoint] - sum[nextPoint]) % MOD;
            }

            nowPoint = nextPoint;
        }
        sc.close();

        System.out.println(result);
    }
}
