from typing import List

class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        n = len(edges)
        par = [-1] * (n + 1)
        rank = [0] * (n + 1)

        def root(node: int) -> int:
            if par[node] == -1: return node
            par[node] = root(par[node])
            return par[node]

        def union(x, y: int) -> bool:
            rx, ry = root(x), root(y)
            if rx == ry: return False
            if rank[rx] < rank[ry]: rx, ry = ry, rx
            par[rx] = ry
            if rank[rx] == rank[ry]: rx += 1
            return True

        for s, t in edges:
            if not union(s, t): return [s, t]

print(Solution().findRedundantConnection([[1,2], [1,3], [2,3]]))