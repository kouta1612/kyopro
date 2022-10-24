package A33;

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

        int xorSum = a[0];
        for (int i = 1; i < n; i++) {
            xorSum ^= a[i];
        }

        if (xorSum == 0) {
            System.out.println("Second");
        } else {
            System.out.println("First");
        }
    }
}
