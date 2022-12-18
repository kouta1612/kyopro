package selection._092;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        while (true) {
            int h = sc.nextInt();
            if (h == 0) {
                break;
            }
            int[][] p = new int[h][5];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < 5; j++) {
                    p[i][j] = sc.nextInt();
                }
            }

            int result = 0;
            List<Point> swapPoints = new ArrayList<>();
            while (true) {
                for (int i = 0; i < h; i++) {
                    boolean found = false;
                    for (int len = 5; len >= 3; len--) {
                        if (found) {
                            break;
                        }
                        for (int j = 0; j <= 5 - len; j++) {
                            if (found) {
                                break;
                            }
                            if (same(j, j + len, p[i])) {
                                swapPoints.add(new Point(i, j, len));
                                result += p[i][j] * len;
                                destroy(j, j + len, p[i]);
                                found = true;
                            }
                        }
                    }
                }
                if (swapPoints.size() == 0) {
                    break;
                }

                Collections.sort(swapPoints);

                for (Point swapPoint : swapPoints) {
                    swap(swapPoint, p);
                }
                swapPoints.clear();
            }

            out.println(result);
        }

        out.flush();
        sc.close();
    }

    static void swap(Point p, int[][] a) {
        for (int i = p.x - 1; i >= 0; i--) {
            for (int j = p.y; j < p.y + p.len; j++) {
                int tmp = a[i + 1][j];
                a[i + 1][j] = a[i][j];
                a[i][j] = tmp;
            }
        }
    }

    static boolean same(int start, int end, int[] a) {
        boolean result = true;
        for (int i = start; i < end - 1; i++) {
            if (a[i] == -1 || a[i + 1] == -1) {
                result = false;
            }
            if (a[i] != a[i + 1]) {
                result = false;
            }
        }

        return result;
    }

    static void destroy(int start, int end, int[] a) {
        for (int i = start; i < end; i++) {
            a[i] = -1;
        }
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