package selection._033;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        String[][] s = new String[h][w];
        for (int i = 0; i < h; i++) {
            s[i] = sc.next().split("");
        }
        sc.close();

        int[][] dist = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                dist[i][j] = 1 << 30;
            }
        }
        dist[0][0] = 0;

        // 経路復元用のデータも記録
        Point[][] rev = new Point[h][w];
        Deque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int[] dx = new int[] { -1, 0, 1, 0 };
            int[] dy = new int[] { 0, 1, 0, -1 };
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (!(0 <= nx && nx < h && 0 <= ny && ny < w)) {
                    continue;
                }
                if (s[nx][ny].equals("#")) {
                    continue;
                }
                if (dist[nx][ny] != 1 << 30) {
                    continue;
                }
                dist[nx][ny] = dist[p.x][p.y] + 1;
                rev[nx][ny] = new Point(p.x, p.y);
                queue.add(new Point(nx, ny));
            }
        }

        if (dist[h - 1][w - 1] == 1 << 30) {
            System.out.println(-1);
            return;
        }

        // すべての通れる点
        int allPoint = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (s[i][j].equals("#")) {
                    continue;
                }
                allPoint++;
            }
        }

        // 実際に通った点
        int walkPoint = 1;
        int x = h - 1, y = w - 1;
        while (!(x == 0 && y == 0)) {
            Point p = rev[x][y];
            x = p.x;
            y = p.y;
            walkPoint++;
        }

        System.out.println(allPoint - walkPoint);
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}