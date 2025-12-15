from types import List

class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        ROWS, COLS = len(matrix), len(matrix[0])
        cache = [[0] * COLS for _ in range(ROWS)]
        self.res = 0

        def dfs(r, c: int) -> int:
            if cache[r][c] != 0: return cache[r][c]

            res = 0
            for nr, nc in [[r+1, c], [r-1, c], [r, c+1], [r, c-1]]:
                if nr < 0 or nc < 0 or nr >= ROWS or nc >= COLS: continue
                if matrix[nr][nc] <= matrix[r][c]: continue
                res = max(res, dfs(nr, nc))

            cache[r][c] = 1 + res
            self.res = max(self.res, cache[r][c])
            return cache[r][c]

        for r in range(ROWS):
            for c in range(COLS):
                if cache[r][c] > 0: continue
                dfs(r, c)
        return self.res

print(Solution().longestIncreasingPath([[9,9,4],[6,6,8],[2,1,1]]))