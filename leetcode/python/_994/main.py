from typing import List
from collections import deque

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        res = 0
        fresh = 0
        deq = deque()
        for r in range(ROWS):
            for c in range(COLS):
                if grid[r][c] == 1: fresh += 1
                if grid[r][c] == 2: deq.append((r, c))

        while len(deq) > 0:
            if fresh == 0: return res
            for _ in range(len(deq)):
                r, c = deq.popleft()
                for nr, nc in [[r+1, c], [r-1, c], [r, c+1], [r, c-1]]:
                    if nr < 0 or nc < 0 or nr >= ROWS or nc >= COLS: continue
                    if grid[nr][nc] != 1: continue
                    fresh -= 1
                    grid[nr][nc] = 2
                    deq.append((nr, nc))
            res += 1
        return res if fresh == 0 else -1

print(Solution().orangesRotting([[2,1,1],[1,1,0],[0,1,1]]))