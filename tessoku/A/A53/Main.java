package A53;

import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        PrintWriter out = new PrintWriter(System.out);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                pq.add(sc.nextInt());
            }
            if (type == 2) {
                out.println(pq.peek());
            }
            if (type == 3) {
                pq.remove();
            }
        }
        sc.close();
        out.flush();
    }
}
