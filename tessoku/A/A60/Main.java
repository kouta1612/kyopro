package A60;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        ArrayDeque<Pair> dq = new ArrayDeque<>();
        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0; i < n; i++) {
            if (i >= 1) {
                dq.addFirst(new Pair(i, a[i - 1]));
                while (dq.size() != 0) {
                    if (a[i] >= dq.getFirst().money) {
                        dq.removeFirst();
                    } else {
                        break;
                    }
                }
            }
            if (dq.size() != 0) {
                out.println(dq.getFirst().day);
            } else {
                out.println(-1);
            }
        }
        out.flush();
    }
}

class Pair {
    int day;
    int money;

    Pair(int day, int money) {
        this.day = day;
        this.money = money;
    }
}