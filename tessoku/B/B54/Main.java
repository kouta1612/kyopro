package B54;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(a[i])) {
                map.put(a[i], map.get(a[i]) + 1);
            } else {
                map.put(a[i], 1L);
            }
        }

        long sum = 0;
        for (long value : map.values()) {
            // sum += (value - 1) + (value - 2) + ... + 1;
            // sum += value * (value - 1) / 2
            sum += value * (value - 1) / 2;
        }

        System.out.println(sum);
    }
}
