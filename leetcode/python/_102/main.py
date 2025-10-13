from typing import Optional, List
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        res, q = [], deque()
        q.append(root)

        while len(q) > 0:
            vs = []
            for _ in range(len(q)):
                now = q.popleft()
                vs.append(now.val)
                q.append(now.left) if now.left else None
                q.append(now.right) if now.right else None
            res.append(vs)
        return res
        
print(Solution().levelOrder(None))