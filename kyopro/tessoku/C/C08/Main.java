package C08;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n];
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
            t[i] = sc.nextInt();
        }
        sc.close();

        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i <= 9999; i++) {
            String numString = String.format("%04d", i);
            boolean f = true;
            for (int j = 0; j < n; j++) {
                if (hantei(numString, s[j]) != t[j]) {
                    f = false;
                }
            }
            if (f) {
                result.add(numString);
            }
        }
        if (result.size() == 1) {
            System.out.println(result.get(0));
        } else {
            System.out.println("Can't Solve");
        }
    }

    static int hantei(String s, String t) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            if (s.charAt(i) == t.charAt(i)) {
                result++;
            }
        }

        if (result == 4) {
            return 1;
        } else if (result == 3) {
            return 2;
        } else {
            return 3;
        }
    }
}
