from typing import List
from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dic = defaultdict(list)
        for s in strs:
            freq = [0] * 26
            for c in s: freq[ord(c) - ord('a')] += 1
            dic[tuple(freq)].append(s)
        return list(dic.values())

print(Solution().groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))