package selection._088;

import java.util.ArrayList;
import java.util.List;
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

        List<Stone> stones = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == 0) { // 最初の操作
                stones.add(new Stone(a[i], 1));
            } else if ((i + 1) % 2 == 1) { // 操作回数が奇数のとき
                Stone lastStone = stones.get(stones.size() - 1);
                if (lastStone.color == a[i]) {
                    lastStone.count++;
                } else {
                    stones.add(new Stone(a[i], 1));
                }
            } else { // 操作回数が偶数のとき
                Stone lastStone = stones.get(stones.size() - 1);
                if (lastStone.color == a[i]) {
                    lastStone.count++;
                } else {
                    if (stones.size() >= 2) {
                        stones.get(stones.size() - 2).count += lastStone.count + 1;
                        stones.remove(stones.size() - 1);
                    } else {
                        lastStone.color = a[i];
                        lastStone.count++;
                    }
                }
            }
        }

        int result = 0;
        for (Stone stone : stones) {
            if (stone.color == 0) {
                result += stone.count;
            }
        }

        System.out.println(result);
    }
}

class Stone {
    int color;
    int count;

    Stone(int color, int count) {
        this.color = color;
        this.count = count;
    }
}