package A55;

import java.io.PrintWriter;
import java.util.TreeSet;
import java.util.Scanner;

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
                set.remove(x);
            }
            if (t == 3) {
                Integer result = set.higher(x - 1);
                if (result == null) {
                    out.println(-1);
                } else {
                    out.println(result);
                }
            }
        }
        sc.close();
        out.flush();
    }
}
