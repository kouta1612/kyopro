from types import List
from heapq import heappop, heappush

class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        n = len(grid)
        heap = [(grid[0][0], 0, 0)]
        visited = set()

        while heap:
            cost, i, j = heappop(heap)
            if i == n - 1 and j == n - 1: return cost
            if (i, j) in visited: continue
            visited.add((i, j))

            dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
            for di, dj in dirs:
                ni, nj = di + i, dj + j
                if ni < 0 or nj < 0 or ni >= n or nj >= n: continue
                if (ni, nj) in visited: continue
                next_cost = max(cost, grid[ni][nj])
                heappush(heap, (next_cost, ni, nj))

print(Solution().swimInWater([[0,2],[1,3]]))
