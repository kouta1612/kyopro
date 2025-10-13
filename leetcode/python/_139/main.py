from typing import List

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False] * (len(s) + 1)
        dp[0] = True

        wordSet = set(wordDict)
        for i in range(1, len(s) + 1):
            for word in wordDict:
                size = i - len(word)
                if size >= 0 and dp[size] and s[size:i] in wordSet: 
                    dp[i] = True
                    break
        return dp[len(s)]

print(Solution().wordBreak("leetcode", ["leet", "code"]))