from collections import defaultdict

class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        s1map, s2map = defaultdict(int), defaultdict(int)
        for c in s1: s1map[c] += 1
        l = 0
        required, counter = len(s1map), 0
        for r in range(len(s2)):
            s2map[s2[r]] += 1
            if s1map[s2[r]] == s2map[s2[r]]: counter += 1
            while r - l + 1 > len(s1):
                if s1map[s2[l]] == s2map[s2[l]]: counter -= 1
                s2map[s2[l]] -= 1
                l += 1
            if required == counter: return True
        return False

print(Solution().checkInclusion("ab", "eidbaooo"))