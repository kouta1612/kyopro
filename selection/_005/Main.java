package selection._005;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.close();

        int result = 0;
        if (a + b >= 2 * c) {
            // x,yの片方がなくなるまでABピザを2セット単位で買う
            while (x > 0 && y > 0) {
                result += 2 * c;
                x--;
                y--;
            }
        }
        if (a > 2 * c) {
            while (x > 0) {
                result += 2 * c;
                x--;
            }
        }
        if (b > 2 * c) {
            while (y > 0) {
                result += 2 * c;
                y--;
            }
        }

        result += a * x + b * y;

        System.out.println(result);
    }
}
