from collections import defaultdict

class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        n = len(s)
        l, r = 0, 0
        counter = defaultdict(int)
        maxCount = 0
        res = 0
        while r < n:
            counter[s[r]] += 1
            maxCount = max(maxCount, counter[s[r]])
            r += 1
            while l < n and r - l - maxCount > k:
                counter[s[l]] -= 1
                l += 1
            res = max(res, r - l)
        return res

print(Solution().characterReplacement("ABAB", 2))
print(Solution().characterReplacement("AABABBA", 1))