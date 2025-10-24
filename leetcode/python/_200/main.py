from typing import List

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        dx, dy = [1, 0, 0, -1], [0, 1, -1, 0]
        def dfs(r, c: int):
            if r < 0 or c < 0 or r >= ROWS or c >= COLS: return
            if grid[r][c] == "0": return
            grid[r][c] = "0"
            for i in range(4):
                nr, nc = r + dx[i], c + dy[i]
                dfs(nr,nc)
        res = 0
        for i in range(ROWS):
            for j in range(COLS):
                if grid[i][j] == "1":
                    dfs(i, j)
                    res += 1
        return res

print(Solution().numIslands([["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]))
print(Solution().numIslands([["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]))