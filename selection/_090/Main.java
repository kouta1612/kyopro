package selection._090;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        double[] x = new double[n + m];
        double[] y = new double[n + m];
        double[] r = new double[n];
        for (int i = 0; i < n + m; i++) {
            x[i] = sc.nextDouble();
            y[i] = sc.nextDouble();
            if (i < n) {
                r[i] = sc.nextDouble();
            }
        }
        sc.close();

        double result = binary_search(x, y, r);

        System.out.println(result);
    }

    /**
     * 汎用的な二分探索法テンプレ
     * 
     * @param a
     * @param key
     * @return
     */
    static double binary_search(double[] x, double[] y, double[] r) {
        // 条件を満たす最大のインデックスを求める場合はng,okの値とisOKの処理を修正する
        double ok = 200;
        double ng = 0;

        // これ以降テンプレなので変える必要なし
        // ng は「常に」条件を満たさず、ok は「常に」条件を満たすよう更新
        while (Math.abs(ok - ng) > 1) {
            double mid = (ok + ng) / 2;

            if (isOK(x, y, r, mid)) {
                ok = mid;
            } else {
                ng = mid;
            }
        }

        // ng は条件を満たさない値、ok は条件を満たす値になっている
        return ok;
    }

    // index が条件を満たすかどうか
    static boolean isOK(double[] x, double[] y, double[] r, double mid) {
        int n = r.length;
        double r1, r2;
        for (int i = 0; i < 2 * n; i++) {
            for (int j = 0; j < 2 * n; j++) {
                if (i < n) {
                    r1 = r[i];
                } else {
                    r1 = mid;
                }

                if (j < n) {
                    r2 = r[i];
                } else {
                    r2 = mid;
                }

                if (!check(x[i], x[j], y[i], y[j], r1, r2)) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean check(double x1, double y1, double r1, double x2, double y2, double r2) {
        double length = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        return r1 + r2 <= length;
    }
}
