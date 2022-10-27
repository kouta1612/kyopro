package selection._011;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] k = new int[m];
        int[][] s = new int[m][n + 1];
        for (int i = 0; i < m; i++) {
            k[i] = sc.nextInt();
            for (int j = 0; j < k[i]; j++) {
                s[i][j] = sc.nextInt();
            }
        }
        int[] p = new int[m];
        for (int i = 0; i < m; i++) {
            p[i] = sc.nextInt();
        }
        sc.close();

        int result = 0;
        // n個のスイッチのon/offをすべて列挙
        for (int i = 0; i < 1 << n; i++) {
            int lightOn = 0;
            for (int j = 0; j < m; j++) {
                int switchOn = 0;
                // 電球jにつながるスイッチj2がonになる総和を求める
                for (int j2 = 0; j2 < k[j]; j2++) {
                    if ((i >> (s[j][j2] - 1)) % 2 == 1) {
                        switchOn++;
                    }
                }
                if (switchOn % 2 == p[j]) {
                    lightOn++;
                }
            }
            if (lightOn == m) {
                result++;
            }
        }

        System.out.println(result);
    }
}
