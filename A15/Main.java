package A15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        List<Integer> b = new ArrayList<>(new HashSet<>(a));
        Collections.sort(b);

        for (int i = 0; i < a.size(); i++) {
            int findIndex = Collections.binarySearch(b, a.get(i));
            a.set(i, findIndex + 1);
        }

        for (int result : a) {
            System.out.println(result);
        }

        sc.close();
    }
}
