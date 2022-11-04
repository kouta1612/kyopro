package selection._027;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int x = sc.nextInt();
        int[][] a = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        sc.close();

        boolean[][] visited = new boolean[x][y];
        int result = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (a[i][j] == 0) {
                    continue;
                }
                int cur = dfs(i, j, 1, visited, a, x, y);
                result = Math.max(result, cur);
            }
        }

        System.out.println(result);
    }

    static int dfs(int x, int y, int count, boolean[][] visited, int[][] a, int maxX, int maxY) {
        visited[x][y] = true;
        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,1,0,-1};

        int result = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!(0 <= nx && nx < maxX && 0 <= ny && ny < maxY)) {
                continue;
            }
            if (a[nx][ny] == 0 || visited[nx][ny]) {
                continue;
            }
            int cur = dfs(nx, ny, count + 1, visited, a, maxX, maxY);
            result = Math.max(result, cur);
        }
        visited[x][y] = false;

        return Math.max(count, result);
    }
}
