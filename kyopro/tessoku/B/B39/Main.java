package B39;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        sc.close();

        boolean[] selected = new boolean[n];
        int result = 0;
        for (int i = 1; i <= d; i++) {
            int maxMoney = 0;
            int found = -1;
            for (int j = 0; j < n; j++) {
                if (i >= x[j] && !selected[j] && maxMoney < y[j]) {
                    maxMoney = y[j];
                    found = j;
                }
            }
            if (found != -1) {
                result += maxMoney;
                selected[found] = true;
            }
        }

        System.out.println(result);
    }
}
