package A10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int d = sc.nextInt();
        int[] l = new int[d];
        int[] r = new int[d];
        for (int i = 0; i < d; i++) {
            l[i] = sc.nextInt();
            r[i] = sc.nextInt();
        }
        sc.close();

        int[] maxFromLeft = new int[n + 1];
        int[] maxFromRight = new int[n + 1];
        maxFromLeft[1] = a[0];
        maxFromRight[n] = a[n - 1];
        for (int i = 2; i <= n; i++) {
            maxFromLeft[i] = Math.max(a[i - 1], maxFromLeft[i - 1]);
        }
        for (int i = n - 1; i >= 1; i--) {
            maxFromRight[i] = Math.max(a[i - 1], maxFromRight[i + 1]);
        }

        for (int i = 0; i < d; i++) {
            System.out.println(Math.max(maxFromLeft[l[i] - 1], maxFromRight[r[i] + 1]));
        }
    }
}
