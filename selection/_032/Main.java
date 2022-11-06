package selection._032;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        while (true) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            if (h == 0 && w == 0) {
                break;
            }

            // (i,j)にいるときに右に壁があるかどうか
            int[][] existRightWall = new int[h][w];
            // (i,j)にいるときに下に壁があるかどうか
            int[][] existUnderWall = new int[h][w];
            for (int i = 0; i < 2 * h - 1; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < w - 1; j++) {
                        existRightWall[i / 2][j] = sc.nextInt();
                    }
                    existRightWall[i / 2][w - 1] = 1;
                } else {
                    for (int j = 0; j < w; j++) {
                        existUnderWall[i / 2][j] = sc.nextInt();
                    }
                }
            }

            // dist[i][j]: マス(0,0)からマス(i,j)に至るまでの最短距離
            int[][] dist = new int[h][w];

            ArrayDeque<Point> queue = new ArrayDeque<>();
            queue.addLast(new Point(0, 0));
            while (!queue.isEmpty()) {
                Point p = queue.removeFirst();
                int[] dx = new int[] { -1, 0, 1, 0 };
                int[] dy = new int[] { 0, 1, 0, -1 };
                for (int i = 0; i < 4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];

                    // マスの範囲外であればスキップ
                    if (!(0 <= nx && nx < h && 0 <= ny && ny < w)) {
                        continue;
                    }

                    // 壁があって移動できなければスキップ
                    // 上方向に移動できなければスキップ
                    if (dx[i] == -1 && existUnderWall[nx][p.y] == 1) {
                        continue;
                    }
                    // 右方向に移動できなければスキップ
                    if (dy[i] == 1 && existRightWall[p.x][p.y] == 1) {
                        continue;
                    }
                    // 下方向に移動できなければスキップ
                    if (dx[i] == 1 && existUnderWall[p.x][p.y] == 1) {
                        continue;
                    }
                    // 左方向に移動できなければスキップ
                    if (dy[i] == -1 && existRightWall[p.x][ny] == 1) {
                        continue;
                    }

                    // すでに訪問済みであればスキップ
                    if (dist[nx][ny] != 0) {
                        continue;
                    }

                    dist[nx][ny] = dist[p.x][p.y] + 1;
                    queue.addLast(new Point(nx, ny));
                }
            }

            if (dist[h - 1][w - 1] == 0) {
                out.println(0);
            } else {
                out.println(dist[h - 1][w - 1] + 1);
            }

        }

        sc.close();
        out.flush();
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}