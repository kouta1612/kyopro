from typing import List

class UnionFind:
    def __init__(self, n: int):
        self.par = [-1] * n
        self.rank = [1] * n

    def root(self, x: int) -> int:
        if self.par[x] == -1: return x
        self.par[x] = self.root(self.par[x])
        return self.par[x]

    def unite(self, x, y: int) -> bool:
        rx, ry = self.root(x), self.root(y)
        if rx == ry: return False

        if self.rank[rx] < self.rank[ry]: rx, ry = ry, rx
        self.par[ry] = rx
        self.rank[rx] += self.rank[ry]
        return True

class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        union = UnionFind(len(edges))
        for s, t in edges:
            s -= 1
            t -= 1
            if not union.unite(s, t): return [s + 1, t + 1]

print(Solution().findRedundantConnection([[1,2], [1,3], [2,3]]))