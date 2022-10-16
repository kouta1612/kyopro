package A72;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int k = sc.nextInt();
        String[][] s = new String[h][w];
        for (int i = 0; i < h; i++) {
            s[i] = sc.next().split("");
        }

        sc.close();

        int result = 0;
        for (int i = 0; i < 1 << h; i++) {
            int count = 0;
            String[][] copy = getCopy(s, h, w);
            // まず行をビット探索
            for (int j = 0; j < h; j++) {
                if ((i >> j) % 2 == 1 && count < k) {
                    // j行目を黒に塗る
                    for (int j2 = 0; j2 < w; j2++) {
                        copy[j][j2] = "#";
                    }
                    count++;
                }
            }

            int remain = k - count;

            // 列を残り回数分だけ黒に塗る
            for (int j = 0; j < remain; j++) {
                int colMaxCount = 0;
                int colNum = -1;
                for (int l = 0; l < w; l++) {
                    int curCount = 0;
                    for (int m = 0; m < h; m++) {
                        if (copy[m][l].equals(".")) {
                            curCount++;
                        }
                    }
                    if (curCount > colMaxCount) {
                        colMaxCount = curCount;
                        colNum = l;
                    }
                }
                if (colNum != -1) {
                    // l列を黒に塗る
                    for (int l = 0; l < h; l++) {
                        copy[l][colNum] = "#";
                    }
                }
            }

            // 全マスの黒をカウント
            int curAllCount = 0;
            for (int j = 0; j < h; j++) {
                for (int j2 = 0; j2 < w; j2++) {
                    if (copy[j][j2].equals("#")) {
                        curAllCount++;
                    }
                }
            }

            result = Math.max(result, curAllCount);
        }

        System.out.println(result);
    }

    static String[][] getCopy(String[][] s, int h, int w) {
        String[][] result = new String[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                result[i][j] = s[i][j];
            }
        }
        return result;
    }
}
