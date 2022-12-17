package selection._091;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double x = sc.nextDouble();
        sc.close();

        // 平面で見たいので奥行きで割る
        double s = x / a;
        if (s >= a * b / 2) {
            System.out.println(Math.atan(2 * (a * b - s) / (a * a)) * 360 / (2 * Math.PI));
        } else {
            System.out.println(Math.atan(b * b / (2 * s)) * 360 / (2 * Math.PI));
        }
    }
}
