package A28;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] t = new String[n];
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = sc.next();
            a[i] = sc.nextInt();
        }
        sc.close();

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (t[i].equals("+")) {
                result += a[i];
            } else if (t[i].equals("-")) {
                result -= a[i];
            } else if (t[i].equals("*")) {
                result *= a[i];
            }

            if (result < 0) {
                result += 10000;
            }

            result %= 10000;
            System.out.println(result);
        }
    }
}
