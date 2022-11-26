package lib.BinarySearch;

public class Main {
    public static void main(String[] args) {
        int[] a = { 1, 2, 4, 5, 5 };

        // 汎用的な二分探索法を使用
        System.out.println(binary_search(a, -1));
        System.out.println(binary_search(a, 100));

        // C++の標準ライブラリを独自実装して使用
        System.out.println(lower_bound(a, 1));
        System.out.println(upper_bound(a, 1));

        // keyの個数を求めることができる
        System.out.println(upper_bound(a, 5) - lower_bound(a, 5));
    }

    /**
     * 汎用的な二分探索法テンプレ
     * 
     * @param a
     * @param key
     * @return
     */
    static int binary_search(int[] a, int key) {
        // 条件を満たす最小のインデックスを求める場合
        int ng = -1; // 「index = 0」が条件を満たすこともあるので、初期値は -1
        int ok = (int) a.length; // 「index = a.length-1」が条件を満たさないこともあるので、初期値は a.length

        // 条件を満たす最大のインデックスを求める場合はng,okの値とisOKの処理を修正する
        // int ok = -1;
        // int ng = (int) a.length;

        // これ以降テンプレなので変える必要なし
        // ng は「常に」条件を満たさず、ok は「常に」条件を満たすよう更新
        while (Math.abs(ok - ng) > 1) {
            int mid = (ok + ng) / 2;

            if (isOK(a, mid, key)) {
                ok = mid;
            } else {
                ng = mid;
            }
        }

        // ng は条件を満たさない値、ok は条件を満たす値になっている
        return ok;
    }

    // index が条件を満たすかどうか
    static boolean isOK(int[] a, int index, int key) {
        if (a[index] >= key) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * a[index] >= key という条件を満たす最小の index を求める
     *
     * @param a
     * @param key
     * @return
     */
    static int lower_bound(int[] a, int key) {
        int left = -1; // 「index = 0」が条件を満たすこともあるので、初期値は -1
        int right = a.length; // 「index = a.length-1」が条件を満たさないこともあるので、初期値は a.length

        // left は「常に」条件を満たさず、right は「常に」条件を満たすよう更新
        while (right - left > 1) {
            int mid = (left + right) / 2;

            if (a[mid] >= key) {
                right = mid;
            } else {
                left = mid;
            }
        }

        // left は条件を満たさない最大の値、right は条件を満たす最小の値になっている
        return right;
    }

    /**
     * a[index] > key という条件を満たす最小の index を求める
     *
     * @param a
     * @param key
     * @return
     */
    static int upper_bound(int[] a, int key) {
        int left = -1; // 「index = 0」が条件を満たすこともあるので、初期値は -1
        int right = a.length; // 「index = a.length-1」が条件を満たさないこともあるので、初期値は a.length

        // left は「常に」条件を満たさず、right は「常に」条件を満たすよう更新
        while (right - left > 1) {
            int mid = (left + right) / 2;

            if (a[mid] > key) {
                right = mid;
            } else {
                left = mid;
            }
        }

        // left は条件を満たさない最大の値、right は条件を満たす最小の値になっている
        return right;
    }
}
