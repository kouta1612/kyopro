package selection._093;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = buf.readLine().split(" ");
        int h = Integer.valueOf(line[0]);
        int w = Integer.valueOf(line[1]);
        int k = Integer.valueOf(line[2]);
        int[][] a = new int[h][w];
        for (int i = 0; i < h; i++) {
            String s = buf.readLine();
            for (int j = 0; j < s.length(); j++) {
                a[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        sc.close();

        int result = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int[][] clone = copy(a);
                clone[i][j] = -1;
                swap(clone, i, j);

                int current = 0;
                for (int l = 0;; l++) {
                    List<Point> points = getPoints(clone, k);
                    if (points.size() == 0) {
                        break;
                    }

                    Collections.sort(points);
                    current += deletePoints(points, clone, l);
                    allSwap(clone, points);
                }

                result = Math.max(result, current);
            }
        }

        System.out.println(result);
    }

    static void allSwap(int[][] a, List<Point> points) {
        for (Point point : points) {
            for (int i = point.x; i >= 1; i--) {
                for (int j = point.y; j < point.y + point.len; j++) {
                    int tmp = a[i][j];
                    a[i][j] = a[i - 1][j];
                    a[i - 1][j] = tmp;
                }
            }
        }
    }

    static int deletePoints(List<Point> points, int[][] a, int number) {
        int result = 0;
        for (Point point : points) {
            int x = point.x;
            int y = point.y;
            result += (1 << number) * a[x][y] * point.len;
            for (int i = y; i < y + point.len; i++) {
                a[x][i] = -1;
            }
        }

        return result;
    }

    static List<Point> getPoints(int[][] a, int k) {
        List<Point> result = new ArrayList<>();
        int h = a.length;
        int w = a[0].length;
        for (int i = 0; i < h; i++) {
            boolean found = false;
            for (int len = w; len >= k; len--) {
                if (found) {
                    break;
                }
                for (int start = 0; start <= w - len; start++) {
                    boolean diff = false;
                    int end = start + len;
                    for (int j = start; j < end - 1; j++) {
                        if (a[i][j] == -1 || a[i][j + 1] == -1) {
                            diff = true;
                            break;
                        }
                        if (a[i][j] != a[i][j + 1]) {
                            diff = true;
                            break;
                        }
                    }
                    if (!diff) {
                        found = true;
                        result.add(new Point(i, start, len));
                        break;
                    }
                }
            }
        }

        return result;
    }

    static void swap(int[][] a, int x, int y) {
        for (int i = x - 1; i >= 0; i--) {
            int tmp = a[i][y];
            a[i][y] = a[i + 1][y];
            a[i + 1][y] = tmp;
        }
    }

    static int[][] copy(int[][] a) {
        int h = a.length;
        int w = a[0].length;
        int[][] result = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                result[i][j] = a[i][j];
            }
        }

        return result;
    }
}

class Point implements Comparable<Point> {
    int x, y, len;

    Point(int x, int y, int len) {
        this.x = x;
        this.y = y;
        this.len = len;
    }

    @Override
    public int compareTo(Point o) {
        return x - o.x;
    }
}
