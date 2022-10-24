package B59;

import java.util.Scanner;

class SegmentTree {
    int size = 1;
    int[] data;

    void init(int n) {
        while (size < n) {
            size *= 2;
        }
        data = new int[size * 2 + 2];
    }

    void update(int pos, int x) {
        pos = pos + size - 1;
        data[pos] = x;
        while (pos >= 2) {
            pos /= 2;
            data[pos] = data[pos * 2] + data[pos * 2 + 1];
        }
    }

    long query(int l, int r, int a, int b, int u) {
        if (r <= a || b <= l) {
            return 0;
        }
        if (l <= a && b <= r) {
            return data[u];
        }
        int mid = (a + b) / 2;
        long halfL = query(l, r, a, mid, u * 2);
        long halfR = query(l, r, mid, b, u * 2 + 1);
        return halfL + halfR;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        SegmentTree sg = new SegmentTree();
        sg.init(n);

        long result = 0;
        for (int i = 0; i < n; i++) {
            result += sg.query(a[i] + 1, n + 1, 1, sg.size + 1, 1);
            sg.update(a[i], 1);
        }

        System.out.println(result);
    }
}
