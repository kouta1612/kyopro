from typing import List

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        mp = dict()
        for s in strs:
            v = ''.join(sorted(s))
            mp[v] = mp.get(v, []) + [s]
        return list(mp.values())

print(Solution().groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))