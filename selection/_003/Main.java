package selection._003;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        sc.close();

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String subS = s.substring(i, j);
                int ns = subS.length();
                boolean check = true;
                for (int k = 0; k < ns; k++) {
                    if (!(subS.charAt(k) == 'A' || subS.charAt(k) == 'C' || subS.charAt(k) == 'G'
                            || subS.charAt(k) == 'T')) {
                        check = false;
                    }
                }
                if (check) {
                    result = Math.max(result, ns);
                }
            }
        }

        System.out.println(result);
    }
}
