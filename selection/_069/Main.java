package selection._069;

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        int[] l = new int[q];
        int[] r = new int[q];
        for (int i = 0; i < q; i++) {
            l[i] = sc.nextInt();
            r[i] = sc.nextInt();
        }
        sc.close();

        boolean[] isPrimes = primes();
        // 2017に似た数の累積
        int[] sum = new int[100001];
        for (int i = 2; i < 100001; i++) {
            if (isPrimes[i] && isPrimes[(i + 1) / 2] && i % 2 == 1) {
                sum[i] = sum[i - 1] + 1;
            } else {
                sum[i] = sum[i - 1];
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0; i < q; i++) {
            out.println(sum[r[i]] - sum[l[i] - 1]);
        }

        out.flush();
    }

    static boolean[] primes() {
        boolean[] isPrimes = new boolean[100001];
        for (int i = 2; i < 100001; i++) {
            isPrimes[i] = true;
        }

        for (int i = 2; i < 100001; i++) {
            if (!isPrimes[i]) {
                continue;
            }
            for (int j = i * 2; j < 100001; j += i) {
                isPrimes[j] = false;
            }
        }

        return isPrimes;
    }
}
