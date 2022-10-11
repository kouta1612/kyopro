package A58;

import java.util.Scanner;

public class Main {
    static int size = 1;
    static int[] data;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        while (size < n) {
            size *= 2;
        }
        data = new int[size * 2 + 2];
        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();
            if (t == 1) {
                int pos = sc.nextInt() + size - 1;
                int x = sc.nextInt();
                data[pos] = x;
                while (pos != 1) {
                    pos /= 2;
                    data[pos] = Math.max(data[pos * 2], data[pos * 2 + 1]);
                }
            }
            if (t == 2) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                System.out.println(query(l, r, 1, size + 1, 1));
            }
        }

        sc.close();
    }

    static int query(int l, int r, int a, int b, int u) {
        if (r <= a || b <= l) {
            return -1000000000;
        }
        if (l <= a && b <= r) {
            return data[u];
        }
        int m = (a + b) / 2;
        int halfL = query(l, r, a, m, u * 2);
        int halfR = query(l, r, m, b, u * 2 + 1);
        return Math.max(halfL, halfR);
    }
}
