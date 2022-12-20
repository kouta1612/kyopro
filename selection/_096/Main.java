package selection._096;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong() - 1;
        sc.close();

        System.out.println(n * (n + 1) / 2);
    }
}
