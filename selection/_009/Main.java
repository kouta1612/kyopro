package selection._009;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            y1[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] x2 = new int[m];
        int[] y2 = new int[m];
        for (int i = 0; i < m; i++) {
            x2[i] = sc.nextInt();
            y2[i] = sc.nextInt();
        }
        sc.close();

        for (int i = 0; i < m; i++) {
            int diffX = x2[i] - x1[0];
            int diffY = y2[i] - y1[0];

            boolean ok = true;
            for (int j = 0; j < n; j++) {
                int newX1 = x1[j] + diffX;
                int newY1 = y1[j] + diffY;

                boolean found = false;
                for (int k = 0; k < m; k++) {
                    if (newX1 == x2[k] && newY1 == y2[k]) {
                        found = true;
                    }
                }

                if (!found) {
                    ok = false;
                }
            }

            if (ok) {
                System.out.println(diffX + " " + diffY);
                return;
            }
        }
    }
}
