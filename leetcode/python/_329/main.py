from types import List
from collections import defaultdict

class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        ROWS, COLS = len(matrix), len(matrix[0])
        cache = defaultdict(int)

        def dfs(r, c: int) -> int:
            if (r, c) in cache: return cache[(r, c)]

            now = 1
            for nr, nc in [[r+1, c], [r, c+1], [r-1, c], [r, c-1]]:
                if nr < 0 or nc < 0 or nr >= ROWS or nc >= COLS: continue
                if matrix[r][c] >= matrix[nr][nc]: continue
                now = max(now, 1 + dfs(nr, nc))

            cache[(r, c)] = now
            return now
        
        res = 0
        for r in range(ROWS):
            for c in range(COLS):
                res = max(res, dfs(r, c))
        return res

print(Solution().longestIncreasingPath([[9,9,4],[6,6,8],[2,1,1]]))