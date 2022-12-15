package selection._089;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        List<Integer> lengthList = new ArrayList<>();
        int currentLength = 1;
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                lengthList.add(currentLength);
            } else if (a[i] != a[i + 1]) {
                currentLength++;
            } else {
                lengthList.add(currentLength);
                currentLength = 1;
            }
        }

        if (lengthList.size() == 1) {
            System.out.println(lengthList.get(0));
            return;
        } else if (lengthList.size() == 2) {
            System.out.println(lengthList.get(0) + lengthList.get(1));
            return;
        }

        int result = 0;
        for (int i = 0; i <= lengthList.size() - 3; i++) {
            result = Math.max(result, lengthList.get(i) + lengthList.get(i + 1) + lengthList.get(i + 2));
        }

        System.out.println(result);
    }
}
