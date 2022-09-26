package A14;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }

        int[] p = new int[n * n];
        int[] q = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                p[i * n + j] = a[i] + b[j];
                // System.out.printf("p[%d] = %d\n", i * n + j, p[i * n + j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                q[i * n + j] = c[i] + d[j];
                // System.out.printf("q[%d] = %d\n", i * n + j, q[i * n + j]);
            }
        }

        Arrays.sort(q);
        for (int i = 0; i < n * n; i++) {
            if (Arrays.binarySearch(q, k - p[i]) >= 0) {
                System.out.println("Yes");
                sc.close();
                return;
            }
        }

        System.out.println("No");

        sc.close();
    }
}
