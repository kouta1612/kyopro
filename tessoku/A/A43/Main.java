package A43;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[] a = new int[n];
        String[] b = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.next();
        }
        sc.close();

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (b[i].equals("E")) {
                result = Math.max(result, l - a[i]);
            } else {
                result = Math.max(result, a[i]);
            }
        }

        System.out.println(result);
    }
}
