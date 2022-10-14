package B64;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static <T> void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Vertex>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            graph[from].add(new Vertex(to, cost));
            graph[to].add(new Vertex(from, cost));
        }

        sc.close();

        int[] cur = new int[n + 1];
        Arrays.fill(cur, 1500000000);
        cur[1] = 0;
        PriorityQueue<Vertex> pq = new PriorityQueue<>(new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                return o1.cost > o2.cost ? 1 : -1;
            }
        });
        pq.add(new Vertex(1, 0));
        boolean[] kakutei = new boolean[n + 1];
        while (pq.size() > 0) {
            // 現在の頂点を確定する
            Vertex now = pq.poll();
            if (kakutei[now.value]) {
                continue;
            }
            kakutei[now.value] = true;

            // 確定した頂点に隣接する未確定の頂点のコストを最小に更新
            for (int i = 0; i < graph[now.value].size(); i++) {
                Vertex next = graph[now.value].get(i);
                if (!kakutei[next.value]) {
                    if (cur[next.value] > cur[now.value] + next.cost) {
                        cur[next.value] = cur[now.value] + next.cost;
                        pq.add(new Vertex(next.value, cur[next.value]));
                    }
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(n);
        int now = n;
        while (now != 1) {
            for (Vertex before : graph[now]) {
                if (cur[before.value] == cur[now] - before.cost) {
                    result.add(before.value);
                    now = before.value;
                }
            }
        }

        Collections.reverse(result);
        StringBuilder builder = new StringBuilder();
        for (Integer integer : result) {
            builder.append(integer + " ");
        }

        System.out.println(builder.toString().trim());
    }
}

class Vertex {
    int value;
    int cost;

    Vertex(int value, int cost) {
        this.value = value;
        this.cost = cost;
    }
}