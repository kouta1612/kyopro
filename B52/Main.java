package B52;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        String s = sc.next();
        sc.close();

        String[] result = s.split("");
        result[x - 1] = "@";

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(x);
        while (deque.size() != 0) {
            int pos = deque.removeLast();
            if (0 <= (pos - 1) - 1 && result[((pos - 1) - 1)].equals(".")) {
                result[(pos - 1) - 1] = "@";
                deque.addFirst(pos - 1);
            }
            if ((pos + 1) - 1 < n && result[((pos + 1) - 1)].equals(".")) {
                result[(pos + 1) - 1] = "@";
                deque.addFirst(pos + 1);
            }
        }

        System.out.println(String.join("", result));
    }
}
