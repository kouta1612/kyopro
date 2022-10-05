package A41;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        sc.close();

        if (s.contains("BBB") || s.contains("RRR")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
