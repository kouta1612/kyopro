from types import List

class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        n, m = len(matrix), len(matrix[0])
        dp = [[0] * m for _ in range(n)]

        def dfs(i, j: int) -> int:
            if dp[i][j] > 0: return dp[i][j]
            res = 1
            for ni, nj in [(i+1, j), (i, j+1), (i-1, j), (i, j-1)]:
                if 0 <= ni < n and 0 <= nj < m and matrix[ni][nj] > matrix[i][j]:
                   res = max(res, 1 + dfs(ni, nj)) 
            dp[i][j] = res
            return dp[i][j]
        
        res = 0
        for i in range(n):
            for j in range(m):
                res = max(res, dfs(i, j))
        return res

print(Solution().longestIncreasingPath([[9,9,4],[6,6,8],[2,1,1]]))