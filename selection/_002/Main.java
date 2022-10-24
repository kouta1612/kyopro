package selection._002;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1 && check(i)) {
                result++;
            }
        }

        System.out.println(result);
    }

    // 約数をちょうど8個もつかどうか
    static boolean check(int n) {
        int result = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                result += 2;
            }
        }

        return result == 8;
    }
}
