package B06;

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
        int[] l = new int[q];
        int[] r = new int[q];

        for (int i = 0; i < q; i++) {
            l[i] = sc.nextInt();
            r[i] = sc.nextInt();
        }

        // maru[i]: i回目までのあたりの回数
        // batu[i]: i回目までのはずれの回数
        int[] maru = new int[n + 1];
        int[] batu = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (a[i] == 1) {
                maru[i + 1] = maru[i] + 1;
                batu[i + 1] = batu[i];
            } else {
                batu[i + 1] = batu[i] + 1;
                maru[i + 1] = maru[i];
            }
        }

        for (int i = 0; i < q; i++) {
            int cMaru = maru[r[i]] - maru[l[i] - 1];
            int cBatu = batu[r[i]] - batu[l[i] - 1];
            if (cMaru - cBatu > 0)
                System.out.println("win");
            else if (cMaru - cBatu == 0)
                System.out.println("draw");
            else
                System.out.println("lose");
        }

        sc.close();
    }
}