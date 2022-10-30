package selection._015;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int[] x;
    static int[] y;
    static ArrayList<Double> dists = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        x = new int[n];
        y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        sc.close();

        int[] seed = new int[n];
        for (int i = 0; i < seed.length; i++) {
            seed[i] = i;
        }

        // すべての順列における距離を算出
        permutation(seed);

        // すべての距離の平均を算出
        double result = 0.0;
        for (double dist : dists) {
            result += dist;
        }
        result /= dists.size();

        System.out.println(result);
    }

    static void permutation(int[] seed) {
        int[] perm = new int[seed.length];
        boolean[] used = new boolean[seed.length];
        buildPerm(0, seed, perm, used);
    }

    static void buildPerm(int pos, int[] seed, int[] perm, boolean[] used) {
        if (pos == perm.length) {
            // 距離を算出
            Double dist = 0.0;
            for (int i = 0; i < perm.length - 1; i++) {
                dist += getDist(x[perm[i]], y[perm[i]], x[perm[i + 1]], y[perm[i + 1]]);
            }

            dists.add(dist);
            return;
        }

        for (int i = 0; i < perm.length; i++) {
            if (used[i]) {
                continue;
            }
            perm[pos] = seed[i];
            used[i] = true;
            buildPerm(pos + 1, seed, perm, used);
            used[i] = false;
        }
    }

    static double getDist(int x1, int y1, int x2, int y2) {
        int diffX = Math.abs(x1 - x2);
        int diffY = Math.abs(y1 - y2);
        return Math.sqrt(diffX * diffX + diffY * diffY);
    }
}
