package C06;

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        PrintWriter out = new PrintWriter(System.out);
        out.println(n);
        for (int i = 1; i < n; i++) {
            out.println(i + " " + (i + 1));
        }
        out.println(1 + " " + n);

        out.flush();
    }
}
