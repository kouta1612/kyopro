package B04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int length = s.length();
        sc.close();

        int result = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '1') {
                result += 1 << (length - i - 1);
            }
        }

        System.out.println(result);
    }
}
