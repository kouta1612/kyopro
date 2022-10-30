package selection._016;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int[] p;
    static int[] q;
    static int count = 1;
    static ArrayList<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        p = new int[n];
        q = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            q[i] = sc.nextInt();
        }
        sc.close();

        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }

        permutation(a);

        if (numbers.size() > 1) {
            int result = Math.abs(numbers.get(0) - numbers.get(1));
            System.out.println(result);
        } else {
            System.out.println(0);
        }
    }

    static void permutation(int[] seed) {
        int[] perm = new int[seed.length];
        boolean[] used = new boolean[seed.length];
        buildPerm(0, seed, perm, used);
    }

    static void buildPerm(int pos, int[] seed, int[] perm, boolean[] used) {
        if (pos == perm.length) {
            boolean ok1 = true;
            boolean ok2 = true;
            for (int i = 0; i < perm.length; i++) {
                if (perm[i] != p[i]) {
                    ok1 = false;
                }
                if (perm[i] != q[i]) {
                    ok2 = false;
                }
            }

            if (ok1 || ok2) {
                numbers.add(count);
            }
            count++;
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
}
