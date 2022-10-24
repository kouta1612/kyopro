package C05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        StringBuilder buf = new StringBuilder();
        n -= 1;
        for (int i = 0; i < 10; i++) {
            if (n == 0) {
                buf.append("4");
                continue;
            }
            if (n % 2 == 1) {
                buf.append("7");
            } else {
                buf.append("4");
            }
            n /= 2;
        }

        System.out.println(buf.reverse().toString());
    }
}
