class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        ns, nt = len(s), len(t)
        dp = [[0] * (nt + 1) for _ in range(ns + 1)]
        for i in range(ns + 1): dp[i][0] = 1
        for i in range(1, ns + 1):
            for j in range(1, nt + 1):
                dp[i][j] = dp[i-1][j]
                if s[i-1] == t[j-1]: dp[i][j] += dp[i-1][j-1]
        return dp[ns][nt]

print(Solution().numDistinct("rabbbit", "rabbit"))