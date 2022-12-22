package selection._098;

import java.util.Scanner;

public class Main {
    static final long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        long[] count = new long[n + 1];
        long result = 1;
        count[0] = 3;
        for (int i = 0; i < n; i++) {
            result = result * count[a[i]] % MOD;
            count[a[i]]--;
            count[a[i] + 1]++;
        }

        System.out.println(result);
    }
}
