from typing import Optional

class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        oldToNewMap = {None: None}
        dummy = Node(0, head)

        def dfs(node: Optional[Node]) -> Optional[Node]:
            if not node: return None
            if node in oldToNewMap: return oldToNewMap[node]

            res = Node(node.val)
            oldToNewMap[node] = res
            res.next = dfs(node.next)
            res.random = dfs(node.random)
            return res
        
        dfs(head)
        return oldToNewMap[dummy.next]

print(Solution().copyRandomList(Node(1, Node(2, Node(3, Node(4, Node(5)))))))