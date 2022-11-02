package selection._022;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double p = sc.nextDouble();
        sc.close();

        double l = -1, r = 1000000000000000000.0;
        while (r - l > 0.0000000001) {
            double mid = (l + r) / 2;
            if (primeFunction(mid, p) >= 0.0) {
                r = mid;
            } else {
                l = mid;
            }
        }

        if (r >= 0.0) {
            System.out.println(function(r, p));
        } else {
            System.out.println(p);
        }
    }

    static double primeFunction(double x, double p) {
        return 1 + p * Math.pow(2, -x / 1.5) * Math.log(Math.pow(2, -2.0 / 3.0));
    }

    static double function(double x, double p) {
        return x + p * Math.pow(2, -x / 1.5);
    }
}
