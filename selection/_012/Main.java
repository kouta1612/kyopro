package selection._012;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] x = new int[m];
        int[] y = new int[m];
        for (int i = 0; i < m; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        sc.close();

        int result = 0;
        for (int i = 1; i < 1<<n; i++) {
            ArrayList<Integer> candidates = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i>>j)%2==1) {
                    candidates.add(j + 1);
                }
            }
            int size = candidates.size();
            boolean ok = true;
            for (int j = 0; j < size; j++) {
                for (int j2 = j + 1; j2 < size; j2++) {
                    boolean check = false;
                    for (int k = 0; k < m; k++) {
                        if ((x[k] == candidates.get(j) && y[k] == candidates.get(j2)) || (x[k] == candidates.get(j2) && y[k] == candidates.get(j))) {
                            check = true;
                        }
                    }
                    if (!check) {
                        ok = false;
                    }
                }
            }
            if (ok) {
                result = Math.max(result, size);
            }
        }

        System.out.println(result);
    }
}
