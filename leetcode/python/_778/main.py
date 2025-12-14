from types import List
from heapq import heappop, heappush

class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        ROWS =  COLS = len(grid)
        heap = [[grid[0][0], 0, 0]]
        visited = set[(int, int)]()
        while heap:
            v, r, c = heappop(heap)
            if r == ROWS - 1 and c == COLS - 1: return v
            if (r, c) in visited: continue
            visited.add((r, c))
            for nr, nc in [[r+1, c], [r-1, c], [r, c+1], [r, c-1]]:
                if nr < 0 or nc < 0 or nr >= ROWS or nc >= COLS: continue
                if (nr, nc) in visited: continue
                heappush(heap, [max(v, grid[nr][nc]), nr, nc])

print(Solution().swimInWater([[0,2],[1,3]]))
