from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node: return None

        nodeMap = {}

        def dfs(node: Optional['Node']) -> Optional['Node']:
            res = Node(node.val)
            nodeMap[node] = res
            for nei in node.neighbors:
                if nei in nodeMap:
                    res.neighbors.append(nodeMap[nei])
                else:
                    v = dfs(nei)
                    res.neighbors.append(v)
            return res
        return dfs(node)