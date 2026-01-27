from typing import List
from heapq import heappop, heappush
from math import abs

class UnionFind:
    def __init__(self, n: int):
        self.par = [-1] * n
        self.rank = [1] * n

    def root(self, x: int) -> int:
        if self.par[x] == -1: return x
        self.par[x] = self.root(self.par[x])
        return self.par[x]

    def union(self, x, y: int) -> bool:
        rx, ry = self.root(x), self.root(y)
        if rx == ry: return False
        if self.rank[rx] < self.rank[ry]: rx, ry = ry, rx
        self.rank[rx] += self.rank[ry]
        self.par[ry] = rx
        return True

    def same(self, x, y: int) -> bool:
        return self.root(x) == self.root(y)

class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        res = 0
        n = len(points)
        uf = UnionFind(n)

        def dist(i, j: int) -> int:
            return abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1])

        edges = []
        for i in range(n):
            for j in range(i + 1, n):
                edges.append((dist(i, j), i, j))
        edges.sort()

        for d, i, j in edges:
            if uf.union(i, j): res += d
        return res

print(Solution().minCostConnectPoints([[0,0],[2,2],[3,10],[5,2],[7,0]]))