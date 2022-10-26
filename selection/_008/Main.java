package selection._008;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        long[] b = new long[n];
        ArrayList<Long> posList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
            b[i] = sc.nextLong();
            posList.add(a[i]);
            posList.add(b[i]);
        }
        sc.close();

        long result = 1L << 60;
        for (Long entryPos : posList) {
            for (Long exitPos : posList) {
                long current = 0;
                for (int i = 0; i < n; i++) {
                    current += Math.abs(entryPos - a[i]) + Math.abs(a[i] - b[i]) + Math.abs(b[i] - exitPos);
                }
                result = Math.min(result, current);
            }
        }

        System.out.println(result);
    }
}
