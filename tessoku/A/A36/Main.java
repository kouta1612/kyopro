package A36;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();

        if (2 * n - 2 <= k && k % 2 == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
