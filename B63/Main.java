package B63;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int sx = sc.nextInt();
        int sy = sc.nextInt();
        int gx = sc.nextInt();
        int gy = sc.nextInt();
        String[][] graph = new String[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            String line = sc.next();
            for (int j = 1; j <= col; j++) {
                graph[i][j] = String.valueOf(line.charAt(j - 1));
            }
        }
        sc.close();

        Queue<Pair> q = new ArrayDeque<>();
        int[][] dist = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dist[i][j] = 1000000000;
            }
        }

        dist[sx][sy] = 0;
        q.add(new Pair(sx, sy));
        while (q.size() > 0) {
            Pair p = q.poll();
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    boolean tateyoko = Math.abs(i + j) % 2 == 1;
                    int nextX = p.x + i;
                    int nextY = p.y + j;
                    if (tateyoko && dist[nextX][nextY] == 1000000000 && graph[nextX][nextY].equals(".")) {
                        dist[nextX][nextY] = dist[p.x][p.y] + 1;
                        q.add(new Pair(nextX, nextY));
                    }
                }
            }
        }

        System.out.println(dist[gx][gy]);
    }
}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}