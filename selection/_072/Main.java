package selection._072;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long w = sc.nextLong();
        long h = sc.nextLong();
        sc.close();

        // factorial[i]: i!(mod p)で事前に求める
        // factorial[w + h - 2] / (factorial[w - 1] * factorial[h - 1])を求める
        // 上記の割り算ではmodを使えないので逆元を利用する
    }
}
