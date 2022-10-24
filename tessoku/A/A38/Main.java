package A38;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int n = sc.nextInt();
        int[] l = new int[n];
        int[] r = new int[n];
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
            r[i] = sc.nextInt();
            h[i] = sc.nextInt();
        }
        sc.close();

        int[] maxWorkHour = new int[d + 1];
        Arrays.fill(maxWorkHour, 24);
        for (int i = 0; i < n; i++) {
            for (int j = l[i]; j <= r[i]; j++) {
                maxWorkHour[j] = Math.min(maxWorkHour[j], h[i]);
            }
        }

        int result = 0;
        for (int i = 1; i <= d; i++) {
            result += maxWorkHour[i];
        }

        System.out.println(result);
    }
}
