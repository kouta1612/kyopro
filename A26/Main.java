package A26;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        int[] x = new int[q];
        for (int i = 0; i < q; i++) {
            x[i] = sc.nextInt();
        }
        sc.close();

        boolean[] isPrime = getIsPrimeList(300000);
        for (int i = 0; i < q; i++) {
            if (isPrime[x[i]]) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    static boolean[] getIsPrimeList(int n) {
        boolean[] result = new boolean[n + 1];
        Arrays.fill(result, true);
        result[0] = result[1] = false;
        for (int i = 2; i * i <= n; i++) {
            for (int j = i * 2; j <= n; j += i) {
                result[j] = false;
            }
        }

        return result;
    }
}
