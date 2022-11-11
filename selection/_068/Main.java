package selection._068;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        List<Integer> result = new ArrayList<>();
        int div = 2;
        int cur = n;
        if (isPrime(n)) {
            System.out.println(n + ": " + n);
            return;
        }
        while (true) {
            if (cur <= 1) {
                break;
            }
            if (cur % div == 0) {
                result.add(div);
                cur /= div;
            } else {
                div++;
            }
        }

        StringBuilder builder = new StringBuilder();
        builder.append(n).append(": ");
        for (Integer item : result) {
            builder.append(item).append(" ");
        }

        System.out.println(builder.toString().trim());
    }

    static boolean isPrime(int x) {
        boolean isDivided = false;
        for (int i = 2; i * i < x; i++) {
            if (x % i == 0) {
                isDivided = true;
            }
        }

        return !isDivided;
    }
}
