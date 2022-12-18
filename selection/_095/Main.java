package selection._095;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long k = sc.nextLong();
        sc.close();

        StringBuilder builder = new StringBuilder();
        if (a <= k) {
            k -= a;
            builder.append(0).append(" ").append(b - k >= 0 ? b - k : 0);

        } else {
            builder.append(a - k).append(" ").append(b);
        }

        System.out.println(builder.toString());
    }
}
