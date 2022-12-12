package selection._081;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        sc.close();

        int[] sum = new int[1000002];
        for (int i = 0; i < n; i++) {
            sum[a[i]]++;
            sum[b[i] + 1]--;
        }

        for (int i = 1; i < 1000002; i++) {
            sum[i] += sum[i - 1];
        }

        int result = 0;
        for (int i = 0; i < 1000002; i++) {
            result = Math.max(result, sum[i]);
        }

        System.out.println(result);
    }
}
