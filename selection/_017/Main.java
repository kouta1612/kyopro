package selection._017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[] x = new int[k];
        int[] y = new int[k];
        for (int i = 0; i < k; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        sc.close();

        Permutation p = new Permutation();
        List<Integer[]> perms = p.make(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7 });
        for (Integer[] perm : perms) {
            String[][] s = new String[8][8];
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (j == perm[i]) {
                        s[i][j] = "Q";
                    } else {
                        s[i][j] = ".";
                    }
                }
            }

            // 入力条件を満たすかどうか確認
            boolean allInputExists = true;
            for (int i = 0; i < k; i++) {
                if (!s[x[i]][y[i]].equals("Q")) {
                    allInputExists = false;
                }
            }
            if (!allInputExists) {
                continue;
            }

            // 入力した盤面でクイーンがかぶらないか確認
            boolean isAlone = true;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (s[i][j].equals("Q")) {
                        // 横縦斜め方向にクイーンがいないことを確認
                        boolean found = false;
                        int[] dx = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };
                        int[] dy = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };
                        for (int l = 0; l < 8; l++) {
                            int newX = i;
                            int newY = j;
                            while (true) {
                                newX += dx[l];
                                newY += dy[l];
                                if (!(0 <= newX && newX <= 7 && 0 <= newY && newY <= 7)) {
                                    break;
                                }
                                if (s[newX][newY].equals("Q")) {
                                    found = true;
                                }
                            }
                        }
                        if (found) {
                            isAlone = false;
                        }
                    }
                }
            }
            if (isAlone) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        builder.append(s[i][j]);
                    }
                    builder.append("\n");
                }
                System.out.print(builder.toString());
                return;
            }
        }
    }
}

class Permutation {
    List<Integer[]> make(Integer[] seed) {
        List<Integer[]> result = new ArrayList<>();
        Integer[] perm = new Integer[seed.length];
        boolean[] used = new boolean[seed.length];
        return buildPerm(0, result, seed, perm, used);
    }

    List<Integer[]> buildPerm(Integer pos, List<Integer[]> result, Integer[] seed, Integer[] perm, boolean[] used) {
        Integer[] newPerm = Arrays.copyOf(perm, perm.length);
        if (pos == newPerm.length) {
            result.add(newPerm);
        }

        for (int i = 0; i < newPerm.length; i++) {
            if (used[i]) {
                continue;
            }
            newPerm[pos] = seed[i];
            used[i] = true;
            buildPerm(pos + 1, result, seed, newPerm, used);
            used[i] = false;
        }

        return result;
    }
}
