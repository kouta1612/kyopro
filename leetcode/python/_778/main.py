from types import List
from heapq import heappop, heappush

class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        n = len(grid)
        heap = [(grid[0][0], 0, 0)]
        res = grid[0][0]
        visited = set()
        while True:
            v, r, c = heappop(heap)
            visited.add((r, c))

            res = max(res, v)
            if r == n - 1 and c == n - 1: return res

            for nr, nc in [[r+1, c], [r, c+1], [r-1, c], [r, c-1]]:
                if nr < 0 or nc < 0 or nr >= n or nc >= n: continue
                if (nr, nc) in visited: continue
                heappush(heap, (grid[nr][nc], nr, nc))
        return res

print(Solution().swimInWater([[0,2],[1,3]]))
