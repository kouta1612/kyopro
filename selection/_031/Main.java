package selection._031;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    // 上から数えた時の偶奇によって異なる
    // (i,j)からみたときの左、右、左上、右上、左下、右下への遷移先
    static int[][] dx = new int[][] { { 0, 0, -1, -1, 1, 1 }, { 0, 0, -1, -1, 1, 1 } };
    static int[][] dy = new int[][] { { -1, 1, 0, 1, 0, 1 }, { -1, 1, -1, 0, -1, 0 } };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int[][] a = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        sc.close();

        // 外枠から塗っていき、塗ることができたら1に更新する
        int[][] paint = new int[h][w];
        ArrayDeque<Point> queue = new ArrayDeque<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                // 外枠でなければスキップ
                if (!(i == 0 || i == h - 1 || j == 0 || j == w - 1)) {
                    continue;
                }
                // 建物が配置されていたらスキップ
                if (a[i][j] == 1) {
                    continue;
                }
                // すでに塗られていたらスキップ
                if (paint[i][j] == 1) {
                    continue;
                }
                paint[i][j] = 1;
                queue.addLast(new Point(i, j));
                while (!queue.isEmpty()) {
                    Point p = queue.removeFirst();
                    paint[p.x][p.y] = 1;
                    for (int k = 0; k < 6; k++) {
                        int nx = p.x + dx[p.x % 2][k];
                        int ny = p.y + dy[p.x % 2][k];
                        // 領域内でなければスキップ
                        if (!(0 <= nx && nx < h && 0 <= ny && ny < w)) {
                            continue;
                        }
                        // 建物が配置されていたらスキップ
                        if (a[nx][ny] == 1) {
                            continue;
                        }
                        // すでに塗られていたらスキップ
                        if (paint[nx][ny] == 1) {
                            continue;
                        }
                        paint[nx][ny] = 1;
                        queue.addLast(new Point(nx, ny));
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                // 塗られていたらスキップ
                if (paint[i][j] == 1) {
                    continue;
                }
                for (int k = 0; k < 6; k++) {
                    int nx = i + dx[i % 2][k];
                    int ny = j + dy[i % 2][k];
                    // 領域外であれば1足してスキップ
                    if (!(0 <= nx && nx < h && 0 <= ny && ny < w)) {
                        result++;
                        continue;
                    }
                    if (paint[nx][ny] == 1) {
                        result++;
                    }
                }
            }
        }

        System.out.println(result);
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}