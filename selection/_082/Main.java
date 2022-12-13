package selection._082;

import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int[] sum = new int[100001];
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                String t = sc.next();
                int start = LocalTime.parse(s).toSecondOfDay();
                int end = LocalTime.parse(t).toSecondOfDay() - 1;
                sum[start]++;
                sum[end + 1]--;
            }

            for (int i = 1; i <= 100000; i++) {
                sum[i] += sum[i - 1];
            }

            int result = 0;
            for (int i = 0; i <= 100000; i++) {
                result = Math.max(result, sum[i]);
            }

            out.println(result);
        }
        sc.close();
        out.flush();
    }
}
