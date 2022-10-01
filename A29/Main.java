package A29;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        sc.close();

        System.out.println(power(a, b, 1000000007));
    }

    static long power(long a, long b, long m) {
        long p = a;
        long result = 1;
        for (int i = 0; i < 30; i++) {
            if ((b >> i) % 2 == 1) {
                result = (result * p) % m;
            }
            p = (p * p) % m;
        }

        return result;
    }
}
