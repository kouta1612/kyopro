from typing import List
from heapq import heappop, heappush
from math import abs

class UnionFind:
    def __init__(self, n: int):
        self.par = [-1] * n
        self.rank = [0] * n

    def root(self, x: int) -> int:
        if self.par[x] == -1: return x
        self.par[x] = self.root(self.par[x])
        return self.par[x]

    def union(self, x, y: int) -> bool:
        rx, ry = self.root(x), self.root(y)
        if rx == ry: return False
        if self.rank[rx] < self.rank[ry]: rx, ry = ry, rx
        self.par[ry] = rx
        self.rank[rx] += self.rank[ry]
        return True

class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        n = len(points)
        heap = []
        for i in range(n):
            x, y = points[i]
            for j in range(i+1, n):
                x2, y2 = points[j]
                cost = abs(x-x2) + abs(y-y2)
                heappush(heap, (cost, i, j))
        res = 0
        uf = UnionFind(n)
        while heap:
            c, i, j = heappop(heap)
            if uf.union(i, j): res += c
        return res

print(Solution().minCostConnectPoints([[0,0],[2,2],[3,10],[5,2],[7,0]]))