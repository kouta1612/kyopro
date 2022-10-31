package selection._018;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        int[] b = new int[q];
        for (int i = 0; i < q; i++) {
            b[i] = sc.nextInt();
        }
        sc.close();

        int result = 0;
        for (int i = 0; i < q; i++) {
            if (Arrays.binarySearch(a, b[i]) >= 0) {
                result++;
            }
        }

        System.out.println(result);
    }
}
