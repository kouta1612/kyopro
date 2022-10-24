package A13;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        long result = 0;
        int tailIndex = 0;
        for (int i = 0; i < n - 1; i++) {
            while (tailIndex <= n - 2 && a[tailIndex + 1] <= a[i] + k) {
                tailIndex++;
                result += tailIndex - i;
            }
        }

        System.out.println(result);
    }
}
