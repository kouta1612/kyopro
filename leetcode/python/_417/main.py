from typing import List

class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        ROWS, COLS = len(heights), len(heights[0])
        pat, atl = set[(int, int)](), set[(int, int)]()

        def dfs(r, c: int, visited: set[(int, int)], prev: int):
            if (r < 0 or c < 0 or r >= ROWS or c >= COLS or
                (r, c) in visited or heights[r][c] < prev):
                return
            visited.add((r, c))
            for nr, nc in [[r + 1, c], [r - 1, c], [r, c + 1], [r, c - 1]]:
                dfs(nr, nc, visited, heights[r][c])

        for r in range(ROWS):
            dfs(r, 0, pat, heights[r][0])
            dfs(r, COLS - 1, atl, heights[r][COLS - 1])
        for c in range(COLS):
            dfs(0, c, pat, heights[0][c])
            dfs(ROWS - 1, c, atl, heights[ROWS - 1][c])

        res = []
        for r in range(ROWS):
            for c in range(COLS):
                if (r, c) in pat and (r, c) in atl:
                    res.append((r, c))
        return res

print(Solution().pacificAtlantic([[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]))