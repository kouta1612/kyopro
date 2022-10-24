package B31;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.close();

        System.out.println(n / 3 + n / 5 + n / 7 - (n / 15 + n / 21 + n / 35) + n / 105);
    }
}
