package B36;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        sc.close();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                sum += 1;
            }
        }

        // 偶奇が重なるとき可能
        if ((k + sum) % 2 == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
