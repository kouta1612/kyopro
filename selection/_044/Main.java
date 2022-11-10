package selection._044;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        List<Integer> triangles = new ArrayList<>();
        List<Integer> regulars = new ArrayList<>();
        for (int i = 1, sum = 1; sum < 1000000; i++, sum += i) {
            triangles.add(sum);
        }
        for (int i = 0, sum = 1; sum < 1000000; i++, sum += triangles.get(i)) {
            regulars.add(sum);
        }
        int[] dp1 = new int[1000001];
        int[] dp2 = new int[1000001];
        for (int i = 0; i < 1000001; i++) {
            dp1[i] = 1<<30;
            dp2[i] = 1<<30;
        }
        dp1[0] = 0;
        dp2[0] = 0;
        for (int i = 1; i < 1000001; i++) {
            for (int regular : regulars) {
                if (i - regular < 0) {
                    continue;
                }
                dp1[i] = Math.min(dp1[i - regular] + 1, dp1[i]);
            }
            for (int regular : regulars) {
                if (i - regular < 0) {
                    continue;
                }
                if (regular % 2 == 0) {
                    continue;
                }
                dp2[i] = Math.min(dp2[i - regular] + 1, dp2[i]);
            }
        }
        while (true) {
            int a = sc.nextInt();
            if (a == 0) {
                break;
            }

            out.println(dp1[a] + " " + dp2[a]);
        }
        out.flush();
        sc.close();
    }
}
