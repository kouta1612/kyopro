from collections import defaultdict

class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        counter = defaultdict(int)
        j, res, maxCount = 0, 0, 0
        for i in range(len(s)):
            while j < len(s) and (j - i + 1) - max(maxCount, counter[s[j]] + 1) <= k:
                counter[s[j]] += 1
                maxCount = max(maxCount, counter[s[j]])
                j += 1
            res = max(res, j - i)
            counter[s[i]] -= 1
        return res

print(Solution().characterReplacement("ABAB", 2))
print(Solution().characterReplacement("AABABBA", 1))