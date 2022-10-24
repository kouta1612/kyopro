package A54;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();
            String s = sc.next();
            if (t == 1) {
                map.put(s, sc.nextInt());
            } else {
                out.println(map.get(s));
            }
        }
        sc.close();
        out.flush();
    }
}
