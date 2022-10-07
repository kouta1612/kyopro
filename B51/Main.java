package B51;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();

        int n = s.length();
        Deque<Integer> deque = new ArrayDeque<>();
        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                deque.addFirst(i + 1);
            } else {
                if (deque.size() != 0) {
                    out.println(deque.pollFirst() + " " + (i + 1));
                }
            }
        }

        out.flush();
    }
}
