package A05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();

        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int rest = k - (i + j);
                if (1 <= rest && rest <= n) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
