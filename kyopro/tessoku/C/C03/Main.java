package C03;

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int x = sc.nextInt();
        int[] a = new int[d + 1];
        a[1] = x;
        for (int i = 2; i <= d; i++) {
            int diff = sc.nextInt();
            a[i] = a[i - 1] + diff;
        }
        int q = sc.nextInt();
        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0; i < q; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            if (a[s] < a[t]) {
                out.println(t);
            } else if (a[s] > a[t]) {
                out.println(s);
            } else {
                out.println("Same");
            }
        }
        sc.close();
        out.flush();
    }
}
