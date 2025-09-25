from typing import List

class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        res = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 1:
                    res = max(res, self.dfs(i, j, grid))
        return res

    def dfs(self, i, j: int, grid: List[List[int]]) -> int:
        if i < 0 or j < 0 or i >= len(grid) or j >= len(grid[i]):
            return 0
        if grid[i][j] == 0:
            return 0
        grid[i][j] = 0
        return 1 + self.dfs(i + 1, j, grid) + self.dfs(i, j + 1, grid) + self.dfs(i - 1, j, grid) + self.dfs(i, j - 1, grid)

print(Solution().maxAreaOfIsland([[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]))