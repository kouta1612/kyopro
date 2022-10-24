package A58;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        SegmentTree sg = new SegmentTree();
        sg.init(n);
        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();
            if (t == 1) {
                int pos = sc.nextInt();
                int x = sc.nextInt();
                sg.update(pos, x);
            }
            if (t == 2) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                System.out.println(sg.query(l, r, 1, sg.size + 1, 1));
            }
        }

        sc.close();
    }
}

class SegmentTree {
    int size;
    int[] data;

    void init(int n) {
        size = 1;
        while (size < n) {
            size *= 2;
        }
        data = new int[size * 2 + 2];
    }

    void update(int pos, int x) {
        pos = pos + size - 1;
        data[pos] = x;
        while (pos != 1) {
            pos /= 2;
            data[pos] = Math.max(data[pos * 2], data[pos * 2 + 1]);
        }
    }

    int query(int l, int r, int a, int b, int u) {
        if (r <= a || b <= l) {
            return -1;
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
