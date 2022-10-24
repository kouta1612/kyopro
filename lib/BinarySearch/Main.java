package lib.BinarySearch;

public class Main {
    public static void main(String[] args) {
        int[] a = { 1, 2, 4, 5, 5 };
        System.out.println(lower_bound(a, 1));
        System.out.println(upper_bound(a, 3));
    }

    /**
     * ある条件(a[i] >= x)を満たす最小のiを求める
     * (lまでは条件を満たさず、r以降は条件を満たすように更新し、rを返すように実装する)
     * 参考：[lower_bound](https://qiita.com/drken/items/97e37dd6143e33a64c8c#2-%E4%B8%80%E8%88%AC%E5%8C%96%E3%81%97%E3%81%9F%E4%BA%8C%E5%88%86%E6%8E%A2%E7%B4%A2%E6%B3%95)
     * 
     * @param a
     * @param key
     * @return
     */
    static int lower_bound(int[] a, int key) {
        int l = -1, r = a.length;
        // 条件を満たすかどうかの堺目が分かる状態になるのはl + 1 = rの状態
        while (r - l > 1) {
            int mid = (l + r) / 2;
            if (a[mid] >= key) {
                r = mid;
            } else {
                l = mid;
            }
        }

        return r;
    }

    /**
     * ある条件(a[i] <= x)を満たす最大のiを求める
     * (lまでは条件を満たし、r以降は条件をみたさないように更新し、lを返すように実装する)
     * 参考：[upper_bound](https://qiita.com/drken/items/97e37dd6143e33a64c8c#2-%E4%B8%80%E8%88%AC%E5%8C%96%E3%81%97%E3%81%9F%E4%BA%8C%E5%88%86%E6%8E%A2%E7%B4%A2%E6%B3%95:~:text=%E4%BB%A3%E3%82%8F%E3%82%8A%E3%81%AB%E4%BB%A5%E4%B8%8B%E3%81%AE%E3%82%88%E3%81%86%E3%81%AB%E3%81%97%E3%81%A6%E3%80%8C%E6%9D%A1%E4%BB%B6%E3%82%92%E6%BA%80%E3%81%9F%E3%81%99%E6%9C%80%E5%A4%A7%E3%81%AE%20index%20%E3%82%92%E6%B1%82%E3%82%81%E3%82%8B%E3%80%8D%E3%81%A8%E3%81%84%E3%81%86%E9%A2%A8%E3%81%AB%E3%81%97%E3%81%9F%E3%81%8F%E3%81%AA%E3%82%8B%E5%A0%B4%E9%9D%A2%E3%82%82%E3%81%82%E3%82%8A%E3%81%BE%E3%81%99%E3%80%82)
     * 
     * @param a
     * @param key
     * @return
     */
    static int upper_bound(int[] a, int key) {
        int l = -1, r = a.length;
        while (r - l > 1) {
            int mid = (l + r) / 2;
            if (a[mid] <= key) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
