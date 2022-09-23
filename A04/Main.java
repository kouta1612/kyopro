package A04;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuffer buf = new StringBuffer();
        for (int i = 9; i >= 0; i--) {
            int binary = (n / (1 << i)) % 2;
            buf.append(binary);
        }

        System.out.println(buf.toString());

        sc.close();
    }
}