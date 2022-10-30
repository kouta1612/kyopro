package lib.Permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Permutation p = new Permutation();
        List<Integer[]> result = p.make(new Integer[] { 1, 2, 3 });
        for (Integer[] list : result) {
            System.out.println(Arrays.toString(list));
        }
    }
}

class Permutation {
    List<Integer[]> make(Integer[] seed) {
        List<Integer[]> result = new ArrayList<>();
        Integer[] perm = new Integer[seed.length];
        boolean[] used = new boolean[seed.length];
        return buildPerm(0, result, seed, perm, used);
    }

    List<Integer[]> buildPerm(Integer pos, List<Integer[]> result, Integer[] seed, Integer[] perm, boolean[] used) {
        Integer[] newPerm = Arrays.copyOf(perm, perm.length);
        if (pos == newPerm.length) {
            result.add(newPerm);
        }

        for (int i = 0; i < newPerm.length; i++) {
            if (used[i]) {
                continue;
            }
            newPerm[pos] = seed[i];
            used[i] = true;
            buildPerm(pos + 1, result, seed, newPerm, used);
            used[i] = false;
        }

        return result;
    }
}
