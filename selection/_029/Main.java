package selection._029;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int sx = sc.nextInt() - 1;
        int sy = sc.nextInt() - 1;
        int gx = sc.nextInt() - 1;
        int gy = sc.nextInt() - 1;
        String[][] s = new String[h][w];
        for (int i = 0; i < h; i++) {
            s[i] = sc.next().split("");
        }
        sc.close();

        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.addLast(new Point(sx, sy));
        int[][] count = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(count[i], 1 << 30);
        }
        count[sx][sy] = 0;
        while (!queue.isEmpty()) {
            Point p = queue.removeFirst();
            int[] dx = new int[] { -1, 0, 1, 0 };
            int[] dy = new int[] { 0, 1, 0, -1 };
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (!(0 <= nx && nx < h && 0 <= ny && ny < w)) {
                    continue;
                }
                if (count[nx][ny] != 1 << 30 || s[nx][ny].equals("#")) {
                    continue;
                }

                count[nx][ny] = count[p.x][p.y] + 1;
                queue.addLast(new Point(nx, ny));
            }
        }

        System.out.println(count[gx][gy]);
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}