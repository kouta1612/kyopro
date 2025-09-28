from typing import List

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False] * (len(s)+1)
        dp[0] = True
        for i in range(len(s) + 1):
            for w in wordDict:
                if i + len(w) <= len(s) and s[i:i+len(w)] == w and dp[i]:
                    dp[i+len(w)] = dp[i]
        return dp[len(s)]


print(Solution().wordBreak("leetcode", ["leet", "code"]))