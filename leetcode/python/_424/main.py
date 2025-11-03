from collections import defaultdict

class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        l, r = 0, 0
        res = 0
        counter = defaultdict(int)
        while r <= len(s):
            while l < len(s):
                maxCount = 0
                for o in range(ord('A'), ord('Z') + 1):
                    maxCount = max(maxCount, counter[chr(o)])
                length = r - l
                if length - maxCount <= k: break
                counter[s[l]] -= 1
                l += 1
            res = max(res, r - l)
            if r < len(s): counter[s[r]] += 1
            r += 1
        return res

print(Solution().characterReplacement("ABAB", 2))
print(Solution().characterReplacement("AABABBA", 1))