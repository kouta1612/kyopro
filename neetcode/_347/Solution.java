package neetcode._347;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map.Entry;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[] { 1, 2, 3, 1, 1, 3, 100, 100, 100, 100 }, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> {
            // 昇順にソート
            return a.getValue() - b.getValue();
        });
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) {
                // 先頭の要素を削除(最小値を削除)
                pq.poll();
            }
        }

        int[] result = new int[k];
        int i = k;
        while (!pq.isEmpty()) {
            result[--i] = pq.poll().getKey();
        }

        return result;
    }
}
