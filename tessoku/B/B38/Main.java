package B38;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        sc.close();

        int currentHeightFromHead = 1;
        int[] limitFromHead = new int[n + 1];
        limitFromHead[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 2) == 'A') {
                currentHeightFromHead += 1;
            } else {
                currentHeightFromHead = 1;
            }
            limitFromHead[i] = currentHeightFromHead;
        }

        int currentHeightFromTail = 1;
        int[] limitFromTail = new int[n + 1];
        limitFromTail[n] = 1;
        for (int i = n - 1; i >= 1; i--) {
            if (s.charAt(i - 1) == 'B') {
                currentHeightFromTail += 1;
            } else {
                currentHeightFromTail = 1;
            }
            limitFromTail[i] = currentHeightFromTail;
        }

        int[] height = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            height[i] = Math.max(limitFromHead[i], limitFromTail[i]);
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += height[i];
        }

        System.out.println(result);
    }
}
