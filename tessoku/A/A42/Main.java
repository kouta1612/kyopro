package A42;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        sc.close();

        int result = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                int sum = 0;
                for (int l = 0; l < n; l++) {
                    if (i <= a[l] && a[l] <= i + k && j <= b[l] && b[l] <= j + k) {
                        sum++;
                    }
                }
                result = Math.max(result, sum);
            }
        }

        System.out.println(result);
    }
}
