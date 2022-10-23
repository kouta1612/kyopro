package C07;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }
        Arrays.sort(c);
        int[] sum = new int[n];
        sum[0] = c[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + c[i];
        }

        int q = sc.nextInt();
        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            // x >= sum[i]を満たす最大のiを求める
            out.println(upper_bound(x, sum));
        }
        sc.close();
        out.flush();
    }

    static int upper_bound(int x, int[] a) {
        int l = 0;
        int r = a.length;
        while (r - l > 0) {
            int mid = (l + r) / 2;
            if (x >= a[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
