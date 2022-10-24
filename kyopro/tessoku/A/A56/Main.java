package A56;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        String s = sc.next();
        int[] a = new int[q];
        int[] b = new int[q];
        int[] c = new int[q];
        int[] d = new int[q];
        for (int i = 0; i < q; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }
        sc.close();

        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            map.put(ch, (ch - 'a') + 1);
        }

        // h[i]: 1文字目からi文字目までのハッシュ値
        long[] h = new long[n + 1];
        h[1] = map.get(s.charAt(0));
        for (int i = 2; i <= n; i++) {
            h[i] = (100 * h[i - 1] + map.get(s.charAt(i - 1))) % 1000000007;
        }

        // p[i]: 100^iを1000000007で割ったあまり
        long[] p = new long[400001];
        p[0] = 1;
        for (int i = 1; i <= 400000; i++) {
            p[i] = p[i - 1] * 100 % 1000000007;
        }

        for (int i = 0; i < q; i++) {
            if (hash(a[i], b[i], h, p) == hash(c[i], d[i], h, p)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    static long hash(int l, int r, long[] h, long[] p) {
        long result = h[r] - (p[r - l + 1] * h[l - 1] % 1000000007);
        if (result < 0) {
            return result + 1000000007;
        }

        return result;
    }
}
