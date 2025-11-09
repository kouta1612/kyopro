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
        res = ""
        for i in range(n):
            for j in range(i + 1, n + 1):
                if dp[i][j] and len(res) < len(s[i:j]):
                    res = s[i:j]
        return res

print(Solution().longestPalindrome("babad"))
print(Solution().longestPalindrome("cbbd"))