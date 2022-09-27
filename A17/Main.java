package A17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n - 1; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n - 2; i++) {
            b[i] = sc.nextInt();
        }

        // 部屋1から部屋iへ移動する最短時間
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1 << 30);
        dp[0] = dp[1] = 0;
        dp[2] = a[0];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + a[i - 2], dp[i - 2] + b[i - 3]);
        }

        List<Integer> result = new ArrayList<>();
        int current = n;
        while (true) {
            result.add(current);
            if (current == 1) {
                break;
            }

            if (dp[current - 1] + a[current - 2] == dp[current]) {
                current -= 1;
            } else {
                current -= 2;
            }
        }

        Collections.reverse(result);

        StringBuilder builder = new StringBuilder();
        for (Integer item : result) {
            builder.append(item).append(" ");
        }

        System.out.println(result.size());
        System.out.println(builder.toString().trim());

        sc.close();
    }
}
