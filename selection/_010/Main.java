package selection._010;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        int[] m = new int[q];
        for (int i = 0; i < q; i++) {
            m[i] = sc.nextInt();
        }
        sc.close();

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 1 << n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i >> j) % 2 == 1) {
                    sum += a[j];
                }
            }
            set.add(sum);
        }

        for (int i = 0; i < q; i++) {
            if (set.contains(m[i])) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
