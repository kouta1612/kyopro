package B65;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] employs = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            employs[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            employs[a].add(b);
            employs[b].add(a);
        }
        sc.close();

        result = new int[n + 1];
        visited = new boolean[n + 1];

        dfs(t, employs);

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            builder.append(result[i] + " ");
        }

        System.out.println(builder.toString().trim());
    }

    // 社員番号がposの階級
    static int dfs(int pos, ArrayList<Integer>[] employs) {
        visited[pos] = true;
        for (int i = 0; i < employs[pos].size(); i++) {
            int member = employs[pos].get(i);
            if (!visited[member]) {
                int memberClass = dfs(member, employs);
                result[pos] = Math.max(result[pos], memberClass + 1);
            }
        }

        return result[pos];
    }
}
