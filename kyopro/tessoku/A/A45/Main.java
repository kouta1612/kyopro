package A45;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String c = sc.next();
        String s = sc.next();
        sc.close();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'B') {
                sum = (sum + 1) % 3;
            }
            if (s.charAt(i) == 'R') {
                sum = (sum + 2) % 3;
            }
        }
        if ((c.equals("W") && sum == 0) || (c.equals("B") && sum == 1) || (c.equals("R") && sum == 2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
