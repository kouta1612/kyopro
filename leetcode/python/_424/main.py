from collections import defaultdict

class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        l, r = 0, 0
        n = len(s)
        counter = defaultdict(int)
        res = 0
        while r < n:
            counter[s[r]] += 1
            while l < n:
                maxCounter = 0
                for o in range(ord('A'), ord('Z') + 1):
                    maxCounter = max(maxCounter, counter[chr(o)])
                remove = r - l + 1 - maxCounter
                if remove <= k: break
                counter[s[l]] -= 1
                l += 1
            res = max(res, r - l + 1)
            r += 1

        return res


print(Solution().characterReplacement("ABAB", 2))
print(Solution().characterReplacement("AABABBA", 1))