package B61;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[m];
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        sc.close();

        ArrayList<Integer>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            g[a[i]].add(b[i]);
            g[b[i]].add(a[i]);
        }

        int max = 0;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int friendsNum = g[i].size();
            if (max < friendsNum) {
                max = friendsNum;
                result = i;
            }
        }

        System.out.println(result);
    }
}
