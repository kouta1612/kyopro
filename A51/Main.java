package A51;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Deque<String> deque = new ArrayDeque<>();
        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                deque.addFirst(sc.next());
            }
            if (type == 2) {
                out.println(deque.getFirst());
            }
            if (type == 3) {
                deque.removeFirst();
            }
        }
        sc.close();
        out.flush();
    }
}
