package selection._090;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        double[] x = new double[n + m];
        double[] y = new double[n + m];
        double[] r = new double[n + m];
        for (int i = 0; i < n + m; i++) {
            x[i] = sc.nextDouble();
            y[i] = sc.nextDouble();
            if (i < n) {
                r[i] = sc.nextDouble();
            } else {
                r[i] = 1e5;
            }
        }
        sc.close();

        double minR = Arrays.stream(r).min().getAsDouble();
        double result = binary_search(n, m, x, y, r, minR);

        System.out.println(result);
    }

    /**
     * 汎用的な二分探索法テンプレ
     *
     * @param a
     * @param key
     * @return
     */
    static double binary_search(int n, int m, double[] x, double[] y, double[] r, double minR) {
        // 条件を満たす最大のインデックスを求める場合はng,okの値とisOKの処理を修正する
        double ok = 0;
        // 最後のWAが取れたのはここの設定が重要な気がする
        double ng = minR + 1e-6;

        // これ以降テンプレなので変える必要なし
        // ng は「常に」条件を満たさず、ok は「常に」条件を満たすよう更新
        while (Math.abs(ok - ng) > 1e-6) {
            double mid = (ok + ng) / 2;

            if (isOK(n, m, x, y, r, mid)) {
                ok = mid;
            } else {
                ng = mid;
            }
        }

        // ng は条件を満たさない値、ok は条件を満たす値になっている
        return ok;
    }

    // index が条件を満たすかどうか
    static boolean isOK(int n, int m, double[] x, double[] y, double[] r, double mid) {
        for (int i = 0; i < n + m; i++) {
            for (int j = i + 1; j < n + m; j++) {
                double r1 = i < n ? r[i] : mid;
                double r2 = j < n ? r[j] : mid;
                if (!check(x[i], x[j], y[i], y[j], r1, r2)) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean check(double x1, double x2, double y1, double y2, double r1, double r2) {
        double length = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        return r1 + r2 <= length;
    }
}
