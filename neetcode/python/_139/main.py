from typing import List

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False] * (len(s) + 1)
        dp[0] = True
        for i in range(len(s) + 1):
            for word in wordDict:
                if i - len(word) >= 0 and s[i-len(word):i] == word and dp[i-len(word)]:
                    dp[i] = True
                    break
        return dp[len(s)]

print(Solution().wordBreak("leetcode", ["leet", "code"]))