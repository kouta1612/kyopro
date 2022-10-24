package A40;

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

        long[] num = new long[200001];
        for (int i = 0; i < n; i++) {
            num[a[i]] += 1;
        }

        long sum = 0;
        for (int i = 1; i <= 200000; i++) {
            if (num[i] >= 3) {
                sum += num[i] * (num[i] - 1) * (num[i] - 2) / 6;
            }
        }

        System.out.println(sum);
    }
}
