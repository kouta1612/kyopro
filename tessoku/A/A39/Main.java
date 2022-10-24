package A39;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static class Interval {
        Integer start;
        Integer last;

        public Interval(Integer start, Integer last) {
            this.start = start;
            this.last = last;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] l = new int[n];
        int[] r = new int[n];
        List<Interval> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
            r[i] = sc.nextInt();
            list.add(new Interval(l[i], r[i]));
        }
        sc.close();

        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.last.compareTo(o2.last);
            }
        });

        int result = 0;
        int current = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                result++;
                current = list.get(i).last;
                continue;
            }
            if (current <= list.get(i).start) {
                result++;
                current = list.get(i).last;
            }
        }

        System.out.println(result);
    }
}
