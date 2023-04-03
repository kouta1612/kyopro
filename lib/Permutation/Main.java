package lib.Permutation;

public class Main {
    public static void main(String[] args) {
        permutation("abcd");
    }

    // 世界で戦うプログラミング力を鍛える本(p60,61)を参照
    static void permutation(String str) {
        permutation(str, "");
    }

    static void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }
}
