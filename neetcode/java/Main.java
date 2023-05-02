package neetcode.java;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Comparator<Integer> comparator = (a, b) -> a - b;
        Integer[] a = new Integer[3];
        a[0] = 100;
        a[1] = 10;
        a[2] = 1000;
        Arrays.sort(a, comparator.reversed());
        for (Integer integer : a) {
            System.out.println(integer);
        }
    }
}
