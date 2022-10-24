package C04;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.close();

        ArrayList<Long> result = new ArrayList<>();
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                result.add(i);
                result.add(n / i);
            }
        }
        Collections.sort(result);
        PrintWriter out = new PrintWriter(System.out);
        for (Long item : result) {
            out.println(item);
        }

        out.flush();
    }
}
