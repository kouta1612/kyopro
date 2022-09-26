package B11;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            Integer x = sc.nextInt();
            System.out.println(lowerBound(a, x));
        }

        sc.close();
    }

    /**
     * 配列から指定した値以上の要素が初めて出現する場所を取得
     * 含まなければ、 (-(挿入位置) - 1) を返すので返り値が負なら、ビット否定をして挿入位置を取得する
     * 参考: https://qiita.com/taskie/items/b4e45e2005aa38e90bcb
     * 
     * @param array
     * @param key
     * @return
     */
    static int lowerBound(Integer[] array, Integer key) {
        return ~Arrays.binarySearch(array, key, (x, y) -> x.compareTo(y) >= 0 ? 1 : -1);
    }
}
