package B56;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static final long MOD = 1000000007;
    static HashMap<Character, Integer> map;
    static long[] power100;
    static long[] headHash;
    static long[] tailHash;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        String s = sc.next();
        int[] l = new int[q];
        int[] r = new int[q];
        for (int i = 0; i < q; i++) {
            l[i] = sc.nextInt();
            r[i] = sc.nextInt();
        }
        sc.close();

        map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, (c - 'a') + 1);
        }

        power100 = new long[200001];
        power100[0] = 1;
        for (int i = 1; i <= 200000; i++) {
            power100[i] = 100 * power100[i - 1] % MOD;
        }

        headHash = new long[n + 1];
        tailHash = new long[n + 2];
        headHash[1] = map.get(s.charAt(0));
        tailHash[n] = map.get(s.charAt(n - 1));

        for (int i = 2; i <= n; i++) {
            headHash[i] = (headHash[i - 1] * 100 + map.get(s.charAt(i - 1))) % MOD;
            tailHash[n - (i - 1)] = (tailHash[n - (i - 1) + 1] * 100 + map.get(s.charAt((n - (i - 1)) - 1))) % MOD;
        }

        for (int i = 0; i < q; i++) {
            if (getHeadHash(l[i], r[i]) == getTailHash(l[i], r[i])) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    static long getHeadHash(int l, int r) {
        long result = (headHash[r] - (power100[r - (l - 1)] * headHash[l - 1])) % MOD;
        if (result < 0) {
            result += MOD;
        }

        return result;
    }

    static long getTailHash(int l, int r) {
        long result = tailHash[l] - (power100[Math.abs(r - (l - 1))] * tailHash[r + 1]) % MOD;
        if (result < 0) {
            result += MOD;
        }

        return result;
    }
}
