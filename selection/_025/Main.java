package selection._025;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> result = new ArrayList<>();
        while (true) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            if (x == 0 && y == 0) {
                break;
            }

            int[][] g = new int[x][y];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    g[i][j] = sc.nextInt();
                }
            }

            boolean[][] visited = new boolean[x][y];
            int count = 0;
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (visited[i][j] || g[i][j] == 0) {
                        continue;
                    }
                    count += dfs(i, j, visited, g, x, y);
                }
            }

            result.add(count);
        }

        for (Integer ans : result) {
            System.out.println(ans);
        }

        sc.close();
    }

    static int dfs(int x, int y, boolean[][] visited, int[][] g, int maxX, int maxY) {
        visited[x][y] = true;

        int[] dx = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };
        int[] dy = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!(0 <= nx && nx < maxX && 0 <= ny && ny < maxY)) {
                continue;
            }
            if (visited[nx][ny]) {
                continue;
            }

            if (g[nx][ny] == 1) {
                dfs(nx, ny, visited, g, maxX, maxY);
            }
        }

        return 1;
    }
}
