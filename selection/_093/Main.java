package selection._093;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int k = sc.nextInt();
        char[][] board = new char[h][];
        for (int i = 0; i < h; i++) {
            board[i] = sc.next().toCharArray();
        }
        sc.close();

        long result = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                char[][] copy = new char[h][];
                for (int l = 0; l < h; l++) {
                    copy[l] = Arrays.copyOf(board[l], w);
                }
                copy[i][j] = '0';
                result = Math.max(result, simulate(copy, k));
            }
        }

        System.out.println(result);
    }

    static long simulate(char[][] board, int k) {
        long score = 0;
        long num = 0;
        while (true) {
            if (!drop(board)) {
                return score;
            }
            score += delete(board, k) << num;
            num++;
        }
    }

    static long delete(char[][] board, int k) {
        int h = board.length;
        int w = board[0].length;
        long result = 0;
        for (int i = 0; i < h; i++) {
            int start = 0;
            for (int end = 1; end < w; end++) {
                if (board[i][end] != board[i][end - 1]) {
                    if (end - start >= k) {
                        // 削除処理
                        for (int l = start; l < end; l++) {
                            result += board[i][l] - '0';
                            board[i][l] = '0';
                        }
                    }
                    start = end;
                }
            }
            // 最後までk個以上連続していたら削除処理
            if (w - start >= k) {
                for (int j = start; j < w; j++) {
                    result += board[i][j] - '0';
                    board[i][j] = '0';
                }
            }
        }

        return result;
    }

    static boolean drop(char[][] board) {
        int h = board.length;
        int w = board[0].length;

        boolean result = false;
        for (int i = 0; i < w; i++) {
            // 下からリバースされる要素のインデックス
            int r = h - 1;
            for (int j = h - 1; j >= 0; j--) {
                if (board[j][i] != '0') {
                    board[r][i] = board[j][i];
                    if (j != r) {
                        board[j][i] = '0';
                        result = true;
                    }
                    r--;
                }
            }
        }

        return result;
    }
}
