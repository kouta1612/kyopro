package selection._030;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int n = sc.nextInt();
        String[][] s = new String[h][w];
        for (int i = 0; i < h; i++) {
            s[i] = sc.next().split("");
        }
        sc.close();

        int sx = 0;
        int sy = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (s[i][j].equals("S")) {
                    sx = i;
                    sy = j;
                }
            }
        }

        int[][] count = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(count[i], 1 << 30);
        }
        count[sx][sy] = 0;
        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.addLast(new Point(sx, sy));
        int[] arriveTime = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            while (!queue.isEmpty()) {
                Point p = queue.removeFirst();
                int[] dx = new int[] { -1, 0, 1, 0 };
                int[] dy = new int[] { 0, 1, 0, -1 };
                for (int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    if (!(0 <= nx && nx < h && 0 <= ny && ny < w)) {
                        continue;
                    }
                    if (s[nx][ny].equals("X") || count[nx][ny] != 1 << 30) {
                        continue;
                    }
                    count[nx][ny] = count[p.x][p.y] + 1;
                    queue.addLast(new Point(nx, ny));
                    if (s[nx][ny].equals(String.valueOf(i))) {
                        arriveTime[i] = count[nx][ny];
                        while (!queue.isEmpty()) {
                            queue.remove();
                        }
                        sx = nx;
                        sy = ny;
                        for (int k = 0; k < h; k++) {
                            Arrays.fill(count[k], 1 << 30);
                        }
                        count[sx][sy] = 0;
                        break;
                    }
                }
            }
            queue.addLast(new Point(sx, sy));
        }

        int result = 0;
        for (int i = 0; i < arriveTime.length; i++) {
            result += arriveTime[i];
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