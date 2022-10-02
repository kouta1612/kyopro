package B33;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int w = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        sc.close();

        int xorSum = 0;
        for (int i = 0; i < n; i++) {
            xorSum ^= a[i] - 1;
            xorSum ^= b[i] - 1;
        }

        if (xorSum == 0) {
            System.out.println("Second");
        } else {
            System.out.println("First");
        }
    }
}
