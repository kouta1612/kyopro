from typing import List

class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        ROWS, COLS = len(heights), len(heights[0])
        pac, atl = set(), set()

        def dfs(r, c: int, visit: set):
            visit.add((r, c))
            for nr, nc in [[r+1, c], [r-1, c], [r, c+1], [r, c-1]]:
                if nr < 0 or nc < 0 or nr >= ROWS or nc >= COLS: continue
                if (nr, nc) in visit: continue
                if heights[nr][nc] < heights[r][c]: continue
                dfs(nr, nc, visit)

        for r in range(ROWS):
            if (r, 0) not in pac: dfs(r, 0, pac)
            if (r, COLS - 1) not in atl: dfs(r, COLS - 1, atl)
        for c in range(COLS):
            if (0, c) not in pac: dfs(0, c, pac)
            if (ROWS - 1, c) not in atl: dfs(ROWS - 1, c, atl)

        res = []
        for r in range(ROWS):
            for c in range(COLS):
                if (r, c) in pac and (r, c) in atl:
                    res.append((r, c))
        return res

print(Solution().pacificAtlantic([[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]))