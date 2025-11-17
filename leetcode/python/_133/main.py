from typing import Optional

class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        mapOldToNew = {}

        def dfs(node: Optional[Node]) -> Optional[Node]:
            if not node: return None
            if node in mapOldToNew: return mapOldToNew[node]
            res = Node(node.val)
            mapOldToNew[node] = res
            for nei in node.neighbors:
                res.neighbors.append(dfs(nei))
            return res

        return dfs(node)


print(Solution().cloneGraph(None))