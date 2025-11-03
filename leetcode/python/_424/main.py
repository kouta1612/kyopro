from collections import defaultdict

class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        l, r = 0, 0
        res = 0
        counter = defaultdict(int)
        maxCount = 0
        while r < len(s):
            counter[s[r]] += 1
            maxCount = max(maxCount, counter[s[r]])
            while r - l + 1 - maxCount > k:
                counter[s[l]] -= 1
                l += 1
            res = max(res, r - l + 1)
            r += 1
        return res

print(Solution().characterReplacement("ABAB", 2))
print(Solution().characterReplacement("AABABBA", 1))