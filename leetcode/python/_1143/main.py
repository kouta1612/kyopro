class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        ROWS, COLS = len(text1), len(text2)
        dp = [[0] * (COLS + 1) for _ in range(ROWS + 1)]
        for r in range(1, ROWS + 1):
            for c in range(1, COLS + 1):
                if text1[r-1] == text2[c-1]:
                    dp[r][c] = max(dp[r][c], dp[r-1][c-1] + 1)
                else:
                    dp[r][c] = max(dp[r][c], dp[r-1][c], dp[r][c-1])
        return dp[ROWS][COLS]

print(Solution().longestCommonSubsequence("abcde", "ace"))