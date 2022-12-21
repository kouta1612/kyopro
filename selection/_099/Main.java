package selection._099;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        long[] d = new long[m];
        long[] c = new long[m];
        for (int i = 0; i < m; i++) {
            d[i] = sc.nextLong();
            c[i] = sc.nextLong();
        }
        sc.close();

        List<Pair> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            result.add(new Pair(d[i] * c[i], c[i] - 1));
        }

        long ans = 0;
        long current = 0;
        for (Pair pair : result) {
            ans += pair.count;
            current += pair.value;
        }

        ans += addition(current);
        System.out.println(ans);
    }

    static long addition(long x) {
        long result = 0;
        while (x >= 10) {
            result++;
            String s = String.valueOf(x/100) + String.valueOf(x%10 + x/10%10);
            x = Long.valueOf(s);
        }

        return result;
    }
}

class Pair {
    long value, count;
    Pair(long value, long count) {
        this.value = value;
        this.count = count;
    }
}