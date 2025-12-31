class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        ROWS, COLS = len(word1), len(word2)
        dp = [[float('inf')] * (COLS + 1) for _ in range(ROWS + 1)]
        for r in range(ROWS + 1):
            for c in range(COLS + 1):
                if r == 0 and c == 0: dp[r][c] = 0
                elif r == 0: dp[r][c] = c
                elif c == 0: dp[r][c] = r
                elif word1[r-1] == word2[c-1]: dp[r][c] = dp[r-1][c-1]
                else: dp[r][c] = 1 + min(dp[r-1][c], dp[r][c-1], dp[r-1][c-1])
        return dp[ROWS][COLS]

print(Solution().minDistance("horse", "ros"))