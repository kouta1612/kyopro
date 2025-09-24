from typing import List

class Solution:
    di, dj = [-1,0,1,0], [0,1,0,-1]
    island = []

    def numIslands(self, grid: List[List[str]]) -> int:
        for i in range(len(grid)):
            vs = []
            for j in range(len(grid[i])):
                vs.append(grid[i][j] == "1")
            self.island.append(vs)
        res = 0
        for i in range(len(self.island)):
            for j in range(len(self.island[i])):
                if self.island[i][j]:
                    res += 1
                    self.dfs(i, j)
        return res

    def dfs(self, i, j: int):
        self.island[i][j] = False
        for k in range(4):
            ni, nj = i + self.di[k], j + self.dj[k]
            if ni < 0 or nj < 0 or ni >= len(self.island) or nj >= len(self.island[ni]):
                continue
            if not self.island[ni][nj]:
                continue
            self.dfs(ni, nj)

print(Solution().numIslands([["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]))
print(Solution().numIslands([["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]))