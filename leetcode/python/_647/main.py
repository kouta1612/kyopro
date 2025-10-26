class Solution:
    def countSubstrings(self, s: str) -> int:
        n = len(s)
        dp = [[False] * n for _ in range(n)]
        res = 0
        for l in range(n - 1, -1, -1):
            for r in range(l, n):
                if s[l] == s[r] and (r - l + 1 <= 3 or dp[l + 1][r - 1]):
                    dp[l][r] = True
                    res += 1
        return res

print(Solution().countSubstrings("abc"))
print(Solution().countSubstrings("aaa"))