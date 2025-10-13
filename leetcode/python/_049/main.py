from typing import List

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        wordDict = dict()
        for s in strs:
            anagram = ''.join(sorted(s))
            if anagram not in wordDict: wordDict[anagram] = []
            wordDict[anagram].append(s)
        res = []
        for v in wordDict.values():
            res.append(v)
        return res

print(Solution().groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))