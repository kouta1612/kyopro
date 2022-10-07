package B55;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();
            int x = sc.nextInt();
            if (t == 1) {
                set.add(x);
            }
            if (t == 2) {
                Integer lower = set.lower(x + 1);
                Integer higher = set.higher(x - 1);
                if (lower == null && higher == null) {
                    out.println(-1);
                } else if (lower == null) {
                    out.println(Math.abs(higher - x));
                } else if (higher == null) {
                    out.println(Math.abs(lower - x));
                } else {
                    out.println(Math.min(Math.abs(lower - x), Math.abs(higher - x)));
                }
            }
        }
        sc.close();
        out.flush();
    }
}
