package selection._014;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        sc.close();

        long result = 1L << 60;
        for (int i = 0; i < 1 << n; i++) {
            long current = 0;
            long[] b = a.clone();
            for (int j = 0; j < n; j++) {
                if ((i >> j) % 2 == 1) {
                    int curIndex = j;
                    // 今見てる建物の高さよりも大きい手前の建物の中で一番高いものを探す
                    for (int l = curIndex - 1; l >= 0; l--) {
                        if (b[l] >= b[curIndex]) {
                            curIndex = l;
                        }
                    }
                    // あったらbとcurrentを更新する
                    if (curIndex != j) {
                        current += (b[curIndex] + 1) - b[j];
                        b[j] = b[curIndex] + 1;
                    }
                }
            }
            // 建物の高さが仕様を満たすかを確認する
            int sum = 1;
            int head = 0, tail = 1;
            while (tail < n) {
                if (b[head] < b[tail]) {
                    head = tail;
                    tail++;
                    sum++;
                } else {
                    tail++;
                }
            }

            if (sum >= k) {
                result = Math.min(result, current);
            }
        }

        System.out.println(result);
    }
}
