from typing import List

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        mp = dict()
        for s in strs:
            v = ''.join(sorted(s))
            mp[v] = mp.get(v, []) + [s]
        res = []
        for v in mp.values():
            res.append(v)
        return res

print(Solution().groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))