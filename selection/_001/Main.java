package selection._001;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            if (n == 0 && x == 0) {
                break;
            }

            int result = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    for (int j2 = j + 1; j2 <= n; j2++) {
                        if (i == j || j == j2 || j2 == i) {
                            continue;
                        }
                        if (i + j + j2 == x) {
                            result++;
                        }
                    }
                }
            }

            System.out.println(result);
        }
        sc.close();
    }
}
