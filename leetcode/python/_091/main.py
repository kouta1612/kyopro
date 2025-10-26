class Solution:
    def numDecodings(self, s: str) -> int:
        digitSet = set()
        for c in range(1, 27):
            digitSet.add(str(c))
        n = len(s)
        dp = [0] * (n + 1)
        dp[0] = 1
        for i in range(1, n + 1):
            if s[i - 1] in digitSet: dp[i] += dp[i-1]
            if i - 2 >= 0 and s[i-2:i] in digitSet: dp[i] += dp[i - 2]
        return dp[n]

print(Solution().numDecodings("12"))
print(Solution().numDecodings("226"))
print(Solution().numDecodings("06"))