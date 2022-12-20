package lib.LCM;

public class Main {
    public static void main(String[] args) {
        System.out.println(lcm(3, 5));
    }

    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}


