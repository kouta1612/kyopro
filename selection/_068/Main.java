package selection._068;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        List<Integer> primes = primeFactorize(n);
        StringBuilder builder = new StringBuilder();
        builder.append(n).append(": ");
        for (Integer prime : primes) {
            builder.append(prime).append(" ");
        }

        System.out.println(builder.toString().trim());
    }

    static List<Integer> primeFactorize(int x) {
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i * i <= x; i++) {
            if (x % i != 0) {
                continue;
            }
            while (x % i == 0) {
                result.add(i);
                x /= i;
            }
        }
        if (x != 1) {
            result.add(x);
        }

        return result;
    }
}
