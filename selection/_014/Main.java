package selection._014;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        sc.close();

        long result = 1L << 60;

        // 見える建物を列挙する
        for (int i = 0; i < 1 << n; i++) {
            // k個以上の建物が見れるかを確認
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i >> j) % 2 == 1) {
                    sum++;
                }
            }

            if (sum < k) {
                continue;
            }

            long totalCost = 0;
            long maxHight = a[0];
            // 建物の高さを増やすコストを計算
            for (int j = 1; j < n; j++) {
                if ((i >> j) % 2 == 1 && maxHight >= a[j]) {
                    totalCost += (maxHight + 1) - a[j];
                    maxHight++;
                }
                maxHight = Math.max(maxHight, a[j]);
            }

            result = Math.min(result, totalCost);
        }

        System.out.println(result);
    }
}
