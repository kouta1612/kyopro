package B14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> p = new ArrayList<Integer>();
        List<Integer> q = new ArrayList<Integer>();
        for (int i = 0; i < n / 2; i++) {
            p.add(sc.nextInt());
        }
        for (int i = n / 2; i < n; i++) {
            q.add(sc.nextInt());
        }

        List<Integer> sumP = getSumList(p);
        List<Integer> sumQ = getSumList(q);

        Collections.sort(sumQ);
        for (Integer itemP : sumP) {
            if (Collections.binarySearch(sumQ, k - itemP) >= 0) {
                System.out.println("Yes");
                sc.close();
                return;
            }
        }

        System.out.println("No");
        sc.close();
    }

    static List<Integer> getSumList(List<Integer> list) {
        int length = list.size();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < (1 << length); i++) {
            int sum = 0;
            for (int j = 0; j < length; j++) {
                if ((i >> j) % 2 == 1) {
                    sum += list.get(j);
                }
            }
            result.add(sum);
        }

        return result;
    }
}
