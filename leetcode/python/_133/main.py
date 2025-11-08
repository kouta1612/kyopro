class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node: return None

        nodeMap = {}

        def dfs(cur: Optional['Node']) -> Optional['Node']:
            if cur in nodeMap: return nodeMap[cur]
            clone = Node(cur.val)
            nodeMap[cur] = clone
            for nei in cur.neighbors:
                clone.neighbors.append(dfs(nei))
            return clone

        return dfs(node)

print(Solution().cloneGraph(None))