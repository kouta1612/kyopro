package A34;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        // 石がi個の時のgrundy数
        int[] grundy = new int[100001];
        for (int i = 0; i <= 100000; i++) {
            boolean[] found = { false, false, false };
            if (i >= x) {
                found[grundy[i - x]] = true;
            }
            if (i >= y) {
                found[grundy[i - y]] = true;
            }

            if (found[0] == false) {
                grundy[i] = 0;
            } else if (found[1] == false) {
                grundy[i] = 1;
            } else if (found[2] == false) {
                grundy[i] = 2;
            }
        }

        int xorSum = 0;
        for (int i = 0; i < n; i++) {
            xorSum ^= grundy[a[i]];
        }

        if (xorSum == 0) {
            System.out.println("Second");
        } else {
            System.out.println("First");
        }
    }
}
