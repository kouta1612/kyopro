package B41;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.close();

        List<Pair> result = new ArrayList<>();
        int count = 0;
        while (true) {
            if (x == 1 && y == 1) {
                break;
            }
            result.add(new Pair(x, y));
            if ((x == 2 && y == 1) || (x == 1 && y == 2)) {
                count++;
                break;
            }
            if (x > y) {
                x -= y;
            } else {
                y -= x;
            }
            count++;
        }

        System.out.println(count);
        Collections.reverse(result);
        for (Pair pair : result) {
            System.out.println(pair.x + " " + pair.y);
        }
    }
}
