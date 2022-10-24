package B02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        boolean found = false;
        // 100の約数: 1,2,4,5,10,20,25,50,100
        for (int i = a; i <= b; i++) {
            if (i == 1 || i == 2 || i == 4 || i == 5 || i == 10 || i == 20 || i == 25 || i == 50 || i == 100) {
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
