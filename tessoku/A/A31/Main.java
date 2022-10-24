package A31;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.close();

        System.out.println(n / 3 + n / 5 - n / 15);
    }
}
