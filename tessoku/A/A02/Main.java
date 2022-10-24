package A02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        boolean found = false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                found = true;
            }
        }

        if (found) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
