package lib.PrimeFactorize;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 1000;
        List<Integer> primes = primeFactorize(n);
        System.out.print(n + ": ");
        for (Integer prime : primes) {
            System.out.print(prime + " ");
        }
        System.out.println();
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
