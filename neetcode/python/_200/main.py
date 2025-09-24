from typing import List

class Solution:
    di, dj = [-1,0,1,0], [0,1,0,-1]

    def numIslands(self, grid: List[List[str]]) -> int:
        res = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == "1":
                    res += 1
                    self.dfs(i, j, grid)
        return res

    def dfs(self, i, j: int, grid: List[List[str]]):
        grid[i][j] = "#"
        for k in range(4):
            ni, nj = i + self.di[k], j + self.dj[k]
            if ni < 0 or nj < 0 or ni >= len(grid) or nj >= len(grid[ni]):
                continue
            if not grid[ni][nj] == "1":
                continue
            self.dfs(ni, nj, grid)

print(Solution().numIslands([["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]))
print(Solution().numIslands([["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]))