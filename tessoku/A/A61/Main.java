package A61;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int[] a = new int[m];
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            a[i] = Integer.valueOf(st.nextToken());
            b[i] = Integer.valueOf(st.nextToken());
        }

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            graph[a[i]].add(b[i]);
            graph[b[i]].add(a[i]);
        }

        PrintWriter out = new PrintWriter(System.out);
        for (int i = 1; i <= n; i++) {
            if (graph[i].size() > 0) {
                StringJoiner sj = new StringJoiner(", ");
                graph[i].forEach(t -> sj.add(String.valueOf(t)));

                out.printf("%d: {%s}\n", i, sj.toString());
            } else {
                out.printf("%d: {}\n", i);
            }
        }

        out.flush();
    }
}
