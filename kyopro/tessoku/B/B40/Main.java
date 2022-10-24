package B40;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        long[] count = new long[101];
        for (int i = 0; i < n; i++) {
            count[a[i] % 100] += 1;
        }

        long sum = 0;
        for (int i = 0; i <= 50; i++) {
            if (i == 0 || i == 50) {
                sum += count[i] * (count[i] - 1) / 2;
            } else {
                sum += count[i] * count[100 - i];
            }
        }

        System.out.println(sum);
    }
}
