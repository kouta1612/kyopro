package lib.Permutation;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        permutation(new int[] { 1, 2, 3 });
    }

    static void permutation(int[] seed) {
        int[] perm = new int[seed.length];
        boolean[] used = new boolean[seed.length];
        buildPerm(0, seed, perm, used);
    }

    static void buildPerm(int pos, int[] seed, int[] perm, boolean[] used) {
        if (pos == perm.length) {
            System.out.println(Arrays.toString(perm));
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
