package selection._006;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        sc.close();

        int result = 0;
        for (int i = 0; i <= 999; i++) {
            String secretS = String.format("%03d", i);
            int firstIndex = -1;
            int secondIndex = -1;
            int thirdIndex = -1;
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == secretS.charAt(0)) {
                    firstIndex = j;
                    break;
                }
            }
            for (int j = firstIndex + 1; j < n; j++) {
                if (s.charAt(j) == secretS.charAt(1)) {
                    secondIndex = j;
                    break;
                }
            }
            for (int j = secondIndex + 1; j < n; j++) {
                if (s.charAt(j) == secretS.charAt(2)) {
                    thirdIndex = j;
                    break;
                }
            }
            if (firstIndex != -1 && secondIndex != -1 && thirdIndex != -1) {
                result++;
            }
        }

        System.out.println(result);
    }
}
