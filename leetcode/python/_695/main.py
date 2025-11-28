from typing import List

class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])

        def dfs(i, j: int) -> int:
            if i < 0 or j < 0 or i >= ROWS or j >= COLS: return 0
            if grid[i][j] == 0: return 0
            grid[i][j] = 0
            res = 1
            for ni, nj in [[i+1, j], [i-1, j], [i, j+1], [i, j-1]]:
                res += dfs(ni, nj)
            return res

        res = 0
        for i in range(ROWS):
            for j in range(COLS):
                if grid[i][j] == 0: continue
                res = max(res, dfs(i, j))
        return res

print(Solution().maxAreaOfIsland([[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]))