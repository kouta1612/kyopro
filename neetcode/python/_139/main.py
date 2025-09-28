from typing import List

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False] * (len(s)+1)
        dp[0] = True
        for i in range(len(s) + 1):
            for w in wordDict:
                if i - len(w) >= 0 and s[i-len(w):i] == w:
                    dp[i] = dp[i-len(w)]
                if dp[i]:
                    break
        return dp[len(s)]

print(Solution().wordBreak("leetcode", ["leet", "code"]))