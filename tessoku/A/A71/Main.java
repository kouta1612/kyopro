package A71;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        Integer[] b = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += a[i] * b[i];
        }

        System.out.println(result);
    }
}
