package selection._099;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        long[] d = new long[m];
        long[] c = new long[m];
        for (int i = 0; i < m; i++) {
            d[i] = sc.nextLong();
            c[i] = sc.nextLong();
        }
        sc.close();

        long digitSum = 0;
        long digitLength = 0;
        for (int i = 0; i < m; i++) {
            digitSum += d[i] * c[i];
            digitLength += c[i];
        }

        System.out.println((digitLength - 1) + (digitSum - 1) / 9);
    }
}
