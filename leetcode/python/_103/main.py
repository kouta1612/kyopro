from typing import List, Optional
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        res, q, bit = [], deque(), 0
        q.append(root)
        while len(q) > 0:
            vs = deque()
            for _ in range(len(q)):
                now = q.popleft()
                vs.appendleft(now.val) if bit else vs.append(now.val)
                q.append(now.left) if now.left else None
                q.append(now.right) if now.right else None
            bit = 1 - bit
            res.append(list(vs))
        return res

print(Solution().zigzagLevelOrder(None))