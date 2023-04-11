package neetcode._049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] hash = new int[26];
            for (char c : s.toCharArray()) {
                hash[c - 'a']++;
            }
            String key = Arrays.toString(hash);
            map.computeIfAbsent(key, k -> new ArrayList<>());
            map.get(key).add(s);
        }

        List<List<String>> result = new ArrayList<>();
        result.addAll(map.values());
        return result;
    }
}
