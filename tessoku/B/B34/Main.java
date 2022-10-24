package B34;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextInt();
        sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        sc.close();

        // grundy[i]: x = 2, y = 3のもとで00112の周期がある
        int xorSum = 0;
        for (int i = 0; i < n; i++) {
            if ((a[i] + 1) % 5 == 0) {
                xorSum ^= 2;
            } else if ((a[i] + 2) % 5 == 0 || (a[i] + 3) % 5 == 0) {
                xorSum ^= 1;
            } else if (a[i] % 5 == 0 || (a[i] + 1) % 5 == 0) {
                xorSum ^= 0;
            }
        }

        if (xorSum == 0) {
            System.out.println("Second");
        } else {
            System.out.println("First");
        }
    }
}
