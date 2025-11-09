class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        dp = [[False] * (n + 1) for _ in range(n + 1)]
        for size in range(2):
            for i in range(n):
                j = i + size
                dp[i][j] = True
        for size in range(2, n + 1):
            for i in range(0, n + 1 - size):
                j = i + size
                if dp[i + 1][j - 1] and s[i] == s[j - 1]:
                    dp[i][j] = True
        for size in range(n + 1, -1, -1):
            for i in range(0, n + 1 - size):
                j = i + size
                if dp[i][j]: return s[i:j]

print(Solution().longestPalindrome("babad"))
print(Solution().longestPalindrome("cbbd"))