from typing import List

class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        pacific, atlantic = set(), set()
        vecs = [(0,1),(0,-1),(1,0),(-1,0)]
        ROWS, COLS = len(heights), len(heights[0])
        def dfs(r, c: int, seen):
            seen.add((r, c))
            for dr, dc in vecs:
                nr, nc = r + dr, c + dc
                if not (0 <= nr < ROWS and 0 <= nc < COLS): continue
                if (nr, nc) in seen: continue
                if heights[nr][nc] < heights[r][c]: continue
                dfs(nr, nc, seen)
        for r in range(ROWS):
            dfs(r, 0, pacific)
            dfs(r, COLS-1, atlantic)
        for c in range(COLS):
            dfs(0, c, pacific)
            dfs(ROWS-1, c, atlantic)
        res = []
        for v in pacific:
            if v in atlantic: res.append(v)
        return res

print(Solution().pacificAtlantic([[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]))